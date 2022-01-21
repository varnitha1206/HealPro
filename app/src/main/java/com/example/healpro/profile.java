package com.example.healpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class profile extends AppCompatActivity {
int cid;
    BottomNavigationView navigationView;
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
        navigationView = findViewById(R.id.bottom_navigation);
//        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_profile);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){

                    case R.id.nav_home:
//                        fragment = new HomeFragment();
                        break;

                    case R.id.nav_treat:
//                        fragment = new SearchFragment();
                        Intent newactivity3= new Intent(getApplicationContext(),treatments.class);
                        newactivity3.putExtra("cid",cid);
                        startActivity(newactivity3);
                        break;

                    case R.id.nav_explore:
//                        fragment = new LikeFragment();
                        Intent newactivity1= new Intent(getApplicationContext(),explore.class);
                        startActivity(newactivity1);
                        break;

                    case R.id.nav_profile:
//                        fragment = new ShopFragment();
                        Intent newactivity2= new Intent(getApplicationContext(),profile.class);
                        newactivity2.putExtra("cid",cid);
                        startActivity(newactivity2);
                        break;
                }
//                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();

                return true;
            }
        });
    }
}