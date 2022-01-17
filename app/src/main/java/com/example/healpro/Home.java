package com.example.healpro;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {


    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //this line hide statusbar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        navigationView = findViewById(R.id.bottom_navigation);
//        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_home);
        Intent customer=getIntent();
        int cid=customer.getIntExtra("cid",0);
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
        ViewPager viewPager;
        int[] images={R.drawable.covid,R.drawable.mask,R.drawable.scd,R.drawable.vaccine};
        ViewPagerAdapter viewPagerAdapter;
            viewPager = (ViewPager) findViewById(R.id.viewPagerMain);
            viewPager.setClickable(false);
            viewPagerAdapter = new ViewPagerAdapter(Home.this,images,cid);
            viewPager.setAdapter(viewPagerAdapter);
    }
}