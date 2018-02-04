package com.apai.trackmymoney;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by Anjana on 10/6/2017.
 */

public class FireBaseHelper {

    DatabaseReference db;
    Boolean saved;
    ArrayList<NewData> sectionDetailsArrayList = new ArrayList<>();
    NewDataAdapter newDataAdapter;

    public FireBaseHelper(DatabaseReference db) {
        this.db = db;
    }

    public Boolean save(NewData newData) {

        if (newData == null) {
            saved = false;
        } else {
            try {
                db.push().setValue(newData);
                saved = true;

                newDataAdapter.notifyDataSetChanged();

            } catch(DatabaseException e) {
                e.printStackTrace();
                saved = false;
            }
        }

        return saved;
    }

    private void fetchData(DataSnapshot dataSnapshot) {
        sectionDetailsArrayList.clear();

        NewData newData = dataSnapshot.getValue(NewData.class);
        sectionDetailsArrayList.add(newData);
    }

    public ArrayList<NewData> retrieve() {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return sectionDetailsArrayList;
    }
}
