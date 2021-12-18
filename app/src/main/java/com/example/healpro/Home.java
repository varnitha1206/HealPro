package com.example.healpro;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {


    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //this line hide statusbar
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        navigationView = findViewById(R.id.bottom_navigation);
////        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomeFragment()).commit();
//        navigationView.setSelectedItemId(R.id.nav_home);
//
//        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Fragment fragment = null;
//                switch (item.getItemId()){
//
//                    case R.id.nav_home:
////                        fragment = new HomeFragment();
//                        break;
//
//                    case R.id.nav_treat:
////                        fragment = new SearchFragment();
//                        break;
//
//                    case R.id.nav_explore:
////                        fragment = new LikeFragment();
//                        break;
//
//                    case R.id.nav_profile:
////                        fragment = new ShopFragment();
//                        break;
//                }
////                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
//
//                return true;
//            }
//        });

    }
}