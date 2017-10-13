package com.apai.trackmymoney;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.apai.trackmymoney.R.id.categoryTextBox;

public class CreateNewExpense extends AppCompatActivity {

    private static final String[] categories = {"Expense", "Income"};
    private static final String[] merchants = new String[]{
            "Costco", "Starbucks", "Walmart", "Home Depot", "Albertsons"
    };
    String selectedCategory;
    String selectedMerchant;
    EditText amountEditText;
    FirebaseDatabase trackMyMoneyDatabase = FirebaseDatabase.getInstance();
    DatabaseReference trackMyMoneyDataRef = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_expense);
        final ArrayAdapter<String> categoryTextBoxAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, categories);
        AutoCompleteTextView categoryTextBox = (AutoCompleteTextView)
                findViewById(R.id.categoryTextBox);
        categoryTextBox.setAdapter(categoryTextBoxAdapter);
        categoryTextBox.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> categoryAdapterView, View view,
                                    int position, long id) {
                selectedCategory = categoryTextBoxAdapter.getItem(position).toString();
                Toast.makeText(CreateNewExpense.this,
                        selectedCategory,
                        Toast.LENGTH_SHORT).show();
            }
        });
        final ArrayAdapter<String> merchantsTextBoxAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, merchants);
        final AutoCompleteTextView merchantsTextBox = (AutoCompleteTextView)
                findViewById(R.id.merchantsTextBox);
        merchantsTextBox.setAdapter(merchantsTextBoxAdapter);
        merchantsTextBox.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> merchantsAdapterView, View view, int position, long id) {
                selectedMerchant = merchantsTextBoxAdapter.getItem(position).toString();
            }
        });
        amountEditText = (EditText) findViewById(R.id.amountTextBox);
        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(Intent);
            }
        });
        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDataToFirebaseDatabase();
            }
        });
    }
    public void saveDataToFirebaseDatabase() {
        if (!categories.equals(null)) {
            String amountEntered = amountEditText.getText().toString();
            String id = trackMyMoneyDataRef.push().getKey();
            NewData newRow = new NewData(selectedCategory, selectedMerchant, amountEntered);
            trackMyMoneyDataRef.child(id).setValue(newRow);
        }
    }
}
