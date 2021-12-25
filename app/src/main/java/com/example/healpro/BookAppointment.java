package com.example.healpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookAppointment extends AppCompatActivity {
TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        Intent in=getIntent();
        String c= in.getStringExtra("Concern : ");
        t1=(TextView) findViewById(R.id.concern);
        t1.setText("Concern specified : "+c);
        Button book=(Button)findViewById(R.id.submit_appointment);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Thank you for reaching out to us! We shall contact you in the next 10-15 mins", Toast.LENGTH_SHORT).show();
            }
        });
    }
}