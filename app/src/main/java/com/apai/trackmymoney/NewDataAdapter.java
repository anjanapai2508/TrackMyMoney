package com.apai.trackmymoney;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Anjana on 10/6/2017.
 */

public class NewDataAdapter extends BaseAdapter {
    Context context;
    ArrayList<NewData>  newDataArrayList;
    public NewDataAdapter(Context context,ArrayList<NewData>  newDataArrayList)
    {
        this.context = context;
        this.newDataArrayList = newDataArrayList;
    }
    @Override
    public int getCount() {
        return newDataArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return newDataArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.summary_textbox,parent,false);
        }
        TextView merchant = (TextView)convertView.findViewById(R.id.merchantsTextBox);
        TextView amount = (TextView)convertView.findViewById(R.id.summaryAmountTextBox);
        TextView category = (TextView)convertView.findViewById(R.id.categoryToDisplayTextBox);
        final NewData newData = (NewData)this.getItem(position);
        merchant.setText("Merchant : " +newData.getMerchant());
        amount.setText("Amount : " +newData.getAmount());
        category.setText("Category : " +newData.getCategory());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, newData.getMerchant(), Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }
}
