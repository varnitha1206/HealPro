package com.example.healpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class start extends AppCompatActivity {
    CarouselView carouselView;
    Button login,register;
    ImageButton doctor;
    int[] sampleImages = {R.drawable.logo, R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start2);
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        login=findViewById(R.id.button2);
        register=findViewById(R.id.button3);
        doctor=findViewById(R.id.imageButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity1Intent = new Intent(getApplicationContext(), login.class);
                startActivity(activity1Intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Toast-check", Toast.LENGTH_SHORT).show();
                Intent activity1Intent = new Intent(getBaseContext(), Register.class);
                startActivity(activity1Intent);
            }
        });
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent doc_login=new Intent(getApplicationContext(),doctor_login.class);
                startActivity(doc_login);
            }
        });
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

}
