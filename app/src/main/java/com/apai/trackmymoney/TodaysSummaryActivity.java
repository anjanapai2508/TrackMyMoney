package com.apai.trackmymoney;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TodaysSummaryActivity extends AppCompatActivity {

    ListView newDataListView;
    DatabaseReference dbReference;
    FireBaseHelper fireBaseHelper;
    NewDataAdapter newDataAdapter;
    ArrayList<NewData> dataListToDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todays_summary);

        newDataListView = (ListView) findViewById(R.id.dailyExpenseSummaryList);
        dbReference = FirebaseDatabase.getInstance().getReference();
        dataListToDisplay = new ArrayList<>();
        dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot newDataSnapshot : dataSnapshot.getChildren())
                {
                    NewData newData = newDataSnapshot.getValue(NewData.class);
                    dataListToDisplay.add(newData);
                }
                NewDataAdapter adapter = new NewDataAdapter(TodaysSummaryActivity.this, dataListToDisplay);
                newDataListView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


    }

