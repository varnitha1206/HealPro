package com.example.healpro;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class treatments extends AppCompatActivity {
    ViewPager viewPager;
    int[] images={R.drawable.dermat,R.drawable.orthopedic,R.drawable.paediatrics,R.drawable.gynecologist,R.drawable.physic};
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatments);
        viewPager = (ViewPager) findViewById(R.id.viewPagerMain);
        viewPagerAdapter = new ViewPagerAdapter(treatments.this,images);
        viewPager.setAdapter(viewPagerAdapter);
    }
}