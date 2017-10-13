package com.apai.trackmymoney;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TodaysSummaryActivity extends AppCompatActivity {

    ListView newData;
    DatabaseReference dbReference;
    FireBaseHelper fireBaseHelper;
    NewDataAdapter newDataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todays_summary);

        newData = (ListView)findViewById(R.id.dailyExpenseSummaryList);
        dbReference = FirebaseDatabase.getInstance().getReference();
        fireBaseHelper = new FireBaseHelper(dbReference);
        newDataAdapter = new NewDataAdapter(this, fireBaseHelper.retrieve());
        newData.setAdapter(newDataAdapter);


    }
}
