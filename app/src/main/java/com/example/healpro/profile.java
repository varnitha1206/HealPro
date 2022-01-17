package com.example.healpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class profile extends AppCompatActivity {
int cid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent in = getIntent();
        cid=in.getIntExtra("cid",0);
        setContentView(R.layout.activity_profile);
        TextView t2 = (TextView)findViewById(R.id.textView7);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pr = new Intent(getApplicationContext(),Patient_prescription.class);
                pr.putExtra("cid",cid);
                startActivity(pr);
            }
        });
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(getApplicationContext(),start.class);
                startActivity(logout);
            }
        });
    }
}