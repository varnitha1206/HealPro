package com.example.healpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Patient_prescription extends AppCompatActivity {
int cid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent in = getIntent();
        cid = in.getIntExtra("cid",0);
        setContentView(R.layout.activity_patient_prescription);
        ImageButton im = (ImageButton)findViewById(R.id.imageButton2);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText n,ph;
                n=(EditText) findViewById(R.id.name_check);
                ph=(EditText) findViewById(R.id.ph_check);
                String name,phone;
                name=n.getText().toString();
                phone=ph.getText().toString();
                DBhandler dBhandler = new DBhandler(Patient_prescription.this);
                String prep  = dBhandler.readmap(cid,name,phone);
                TextView t = (TextView) findViewById(R.id.prescription);
                t.setText(prep);
                t.setVisibility(View.VISIBLE);
            }
        });

    }
}