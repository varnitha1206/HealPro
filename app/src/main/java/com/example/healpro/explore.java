package com.example.healpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;

public class explore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        ImageButton ib1,ib2,ib3,ib4,ib5;
        ib1=(ImageButton)findViewById(R.id.b1);
        ib2=(ImageButton)findViewById(R.id.b2);
        ib3=(ImageButton)findViewById(R.id.b3);
        ib4=(ImageButton)findViewById(R.id.b4);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.thehealthymaven.com/"));
                startActivity(i);
            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fitfoodiefinds.com/"));
                startActivity(i);
            }
        });
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://therealfooddietitians.com/"));
                startActivity(i);
            }
        });
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naturallivingideas.com/"));
                startActivity(i);
            }
        });
    }
}