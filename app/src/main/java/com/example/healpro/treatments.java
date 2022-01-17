package com.example.healpro;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class treatments extends AppCompatActivity {
    ViewPager viewPager;
    int[] images={R.drawable.dermat,R.drawable.orthopedic,R.drawable.paediatrics,R.drawable.gynecologist,R.drawable.physic};
    ViewPagerAdapter viewPagerAdapter;
    int cid;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Intent customer=getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatments);
        cid=customer.getIntExtra("cid",0);
        viewPager = (ViewPager) findViewById(R.id.viewPagerMain);
        viewPagerAdapter = new ViewPagerAdapter(treatments.this,images,cid);
        viewPager.setAdapter(viewPagerAdapter);
    }
}