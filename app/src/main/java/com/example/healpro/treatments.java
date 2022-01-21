package com.example.healpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class treatments extends AppCompatActivity {
    ViewPager viewPager;
    int[] images={R.drawable.dermat,R.drawable.orthopedic,R.drawable.paediatrics,R.drawable.gynecologist,R.drawable.physic};
    ViewPagerAdapter viewPagerAdapter;
    int cid;
    BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Intent customer=getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatments);
        cid=customer.getIntExtra("cid",0);
        viewPager = (ViewPager) findViewById(R.id.viewPagerMain);
        viewPagerAdapter = new ViewPagerAdapter(treatments.this,images,cid,00);
        viewPager.setAdapter(viewPagerAdapter);
        navigationView = findViewById(R.id.bottom_navigation);
//        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_treat);
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