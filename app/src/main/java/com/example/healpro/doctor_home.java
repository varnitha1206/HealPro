package com.example.healpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class doctor_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);
        Intent login = getIntent();
        String name= login.getStringExtra("Dr. ");
        getSupportActionBar().setTitle(name);
    }
}