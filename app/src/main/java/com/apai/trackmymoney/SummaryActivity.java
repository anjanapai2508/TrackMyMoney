package com.apai.trackmymoney;

import android.net.Uri;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Button todaysSummary = (Button) findViewById(R.id.todaysSummary);
        todaysSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TodaysSummaryActivity.class);
                view.getContext().startActivity(intent);
            }
        });
        Button thisMonthSummary = (Button) findViewById(R.id.monthsSummary);
        Button goBackToMainPageButton = (Button) findViewById(R.id.goBackToMainPageButton);
        goBackToMainPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }


}
