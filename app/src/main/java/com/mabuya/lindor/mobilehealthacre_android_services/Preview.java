package com.mabuya.lindor.mobilehealthacre_android_services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Address;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.AddressRepository;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl.AddressRepositoryImpl;

public class Preview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        Button myPreview = (Button)findViewById(R.id.btnSave);
        Intent myIntent = getIntent();

        final Address myAddressCatch = (Address) myIntent.getSerializableExtra("AddressValue");

        //delete after testing
        Toast.makeText(Preview.this,myAddressCatch.toString(),Toast.LENGTH_LONG).show();

        EditText editText  = (EditText) findViewById(R.id.displayAll);
        editText.setText(myAddressCatch.toString());

        myPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddressRepository addressRepository = new AddressRepositoryImpl(getApplicationContext());
                addressRepository.save(myAddressCatch);

                //calling display window
                Intent intent = new Intent(v.getContext(),Display.class);
                startActivity(intent);
            }
        });

    }
}
