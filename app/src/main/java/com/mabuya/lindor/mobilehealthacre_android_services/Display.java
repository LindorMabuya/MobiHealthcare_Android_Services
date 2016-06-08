package com.mabuya.lindor.mobilehealthacre_android_services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.TableRow.LayoutParams;


import com.mabuya.lindor.mobilehealthacre_android_services.domain.Address;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.AddressRepository;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl.AddressRepositoryImpl;

import java.util.Set;

public class Display extends Activity {

   /* TableLayout tableLayout;
    TableRow tableRow;
    TextView idTextView,streetNumTextView, streetNameTextView, townTextView, cityTextView, zipCodeTextView;*/
    Set<Address> addresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Button myHomeBtn = (Button)findViewById(R.id.btnHome);
        AddressRepository repo = new AddressRepositoryImpl(getApplicationContext());

        //Read All
        addresses = repo.findAll();
        Toast.makeText(Display.this,addresses.toString(),Toast.LENGTH_LONG).show();

        TextView textView = (TextView) findViewById(R.id.multTxt);
        String cont ="";
      for(Address address: addresses){
          cont +=address.getId()+" "+address.getStreetNumber()+" "+address.getStreetName()+" "+address.getTown()+" "+address.getCity()+" "+
                  address.getZipCode()+"\n";
      }
        textView.setText(cont);
        myHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //calling home window
                Intent intent = new Intent(v.getContext(),MobileHealthcareActivity.class);
                startActivity(intent);

            }
        });
    }


 /*   public void addHeaders() {
        *//** Create a TableRow dynamically **//*
        tableRow = new TableRow(this);
        tableRow.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT ));

        *//** Creating a TextView to add to the row **//*
        TextView id = new TextView(this);
        id.setText("Id no: ");
        id.setTextColor(Color.YELLOW);
        id.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        id.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        id.setPadding(5, 5, 5, 0);
        tableRow.addView(id);  // Adding textView to tableRow.

        *//** Creating another textView **//*
        TextView colNum = new TextView(this);
        colNum.setText("Street no: ");
        colNum.setTextColor(Color.YELLOW);
        colNum.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        colNum.setPadding(5, 5, 5, 0);
        colNum.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tableRow.addView(colNum); // Adding textView to tableRow.


        *//** Creating another textView **//*
        TextView colName = new TextView(this);
        colName.setText("Street Name: ");
        colName.setTextColor(Color.YELLOW);
        colName.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        colName.setPadding(5, 5, 5, 0);
        colName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tableRow.addView(colName); // Adding textView to tableRow.


        *//** Creating another textView **//*
        TextView colTown = new TextView(this);
        colTown.setText("Town: ");
        colTown.setTextColor(Color.YELLOW);
        colTown.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        colTown.setPadding(5, 5, 5, 0);
        colTown.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tableRow.addView(colTown); // Adding textView to tableRow.

        *//** Creating another textView **//*
        TextView colCity = new TextView(this);
        colCity.setText("Town: ");
        colCity.setTextColor(Color.YELLOW);
        colCity.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        colCity.setPadding(5, 5, 5, 0);
        colCity.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tableRow.addView(colTown); // Adding textView to tableRow.

        *//** Creating another textView **//*
        TextView colZipCode = new TextView(this);
        colZipCode.setText("Zip code: ");
        colZipCode.setTextColor(Color.YELLOW);
        colZipCode.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        colZipCode.setPadding(5, 5, 5, 0);
        colZipCode.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tableRow.addView(colZipCode); // Adding textView to tableRow.


        // we are adding two textViews for the divider because we have two columns
        tableRow = new TableRow(this);
        tableRow.setLayoutParams(new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));




    }


    *//** This function add the data to the table **//*
    public void addData()
    {
        for (Address myAddress : addresses)
        {

            *//** Create a TableRow dynamically **//*
            tableRow = new TableRow(this);
            tableRow.setLayoutParams(new LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));

            idTextView = new TextView(this);
            idTextView.setText(myAddress.getId().toString());
            idTextView.setTextColor(Color.RED);
            idTextView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            idTextView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            idTextView.setPadding(5, 5, 5, 5);
            tableRow.addView(idTextView); // Adding textView to tableRow.


            *//** Creating another textView **//*
            streetNumTextView = new TextView(this);
            streetNumTextView.setText(Integer.toString(myAddress.getStreetNumber()));
            streetNumTextView.setTextColor(Color.GREEN);
            streetNumTextView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            streetNumTextView.setPadding(5, 5, 5, 5);
            streetNumTextView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tableRow.addView(streetNumTextView); // Adding textView to tableRow .*//*


            *//** Creating another textView **//*
            streetNameTextView = new TextView(this);
            streetNameTextView.setText(myAddress.getStreetName().toString());
            streetNameTextView.setTextColor(Color.GREEN);
            streetNameTextView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            streetNameTextView.setPadding(5, 5, 5, 5);
            streetNameTextView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tableRow.addView(streetNameTextView); // Adding textView to tableRow.*//*

            *//** Creating another textView **//*
            townTextView = new TextView(this);
            townTextView.setText(myAddress.getTown().toString());
            townTextView.setTextColor(Color.GREEN);
            townTextView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            townTextView.setPadding(5, 5, 5, 5);
            townTextView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tableRow.addView(townTextView); // Adding textView to tableRow.*//*

            *//** Creating another textView **//*
            cityTextView = new TextView(this);
            cityTextView.setText(myAddress.getTown().toString());
            cityTextView.setTextColor(Color.GREEN);
            cityTextView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            cityTextView.setPadding(5, 5, 5, 5);
            cityTextView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tableRow.addView(cityTextView); // Adding textView to tableRow.*//*

            *//** Creating another textView **//*
            zipCodeTextView = new TextView(this);
            streetNumTextView.setText(Integer.toString(myAddress.getZipCode()));
            zipCodeTextView.setTextColor(Color.GREEN);
            zipCodeTextView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            zipCodeTextView.setPadding(5, 5, 5, 5);
            zipCodeTextView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tableRow.addView(zipCodeTextView); // Adding textView to tableRow.*//*

            // Add the TableRow to the TableLayout
            tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));

        }


    }*/


}
