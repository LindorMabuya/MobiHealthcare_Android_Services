package com.mabuya.lindor.mobilehealthacre_android_services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Address;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnPreview = (Button) findViewById(R.id.btnPreview);

        final EditText myId = (EditText) findViewById(R.id.idTxt);
        final EditText streetNum = (EditText) findViewById(R.id.streetTxt);
        final EditText streetName = (EditText) findViewById(R.id.nameTxt);
        final EditText town = (EditText) findViewById(R.id.townTxt);
        final EditText city = (EditText) findViewById(R.id.cityTxt);
        final EditText code = (EditText) findViewById(R.id.codeTxt);

        btnPreview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Long id = Long.parseLong(myId.getText().toString());
                int streetNumber = Integer.parseInt(streetNum.getText().toString());
                String name = streetName.getText().toString();
                String streetTown = town.getText().toString();
                String streetCity = city.getText().toString();
                int zipCode = Integer.parseInt(code.getText().toString());

                Address address = new Address.Builder()
                        .id(id)
                        .streetNumber(streetNumber)
                        .streetName(name)
                        .town(streetTown)
                        .city(streetCity)
                        .zipCode(zipCode)
                        .build();

                Intent intent = new Intent(v.getContext(),Preview.class);
                intent.putExtra("AddressValue", address);

                startActivity(intent);
            }
        });

    }
}
