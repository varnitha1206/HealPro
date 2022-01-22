package com.example.healpro;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class doctor_home extends AppCompatActivity {
//    String patients[] = {"Stephanie", "Brian", "Nicole", "Nicholas", "Anthony", "Heather", "Eric", "Elizabeth"};
    ListView spin;
    int o;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);
        DBhandler dBhandler;
        dBhandler = new DBhandler(doctor_home.this);
        Intent login = getIntent();
        o = login.getIntExtra("spd",0);
        o=o-1;
        String spd = String.valueOf(o);
        ImageButton ib = (ImageButton) findViewById(R.id.imageButton3);
        ArrayList<String> patients = dBhandler.list(spd);
        spin = (ListView)findViewById(R.id.listview);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, R.layout.listview,R.id.patients_display,patients);
        spin.setAdapter(aa);
        spin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String details = patients.get(position);
                String[] det = details.split("-");
                String ph = det[1];
                String p_n = det[0];
                PopupMenu popup = new PopupMenu(doctor_home.this, spin);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        // Toast message on menu item clicked
                        if(menuItem.getTitle().equals("Call"))
                        {
                            Intent c = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + ph));
                            startActivity(c);
                        }
                        if(menuItem.getTitle().equals("Prescribe"))
                        {
                            Intent c = new Intent(getApplicationContext(),doctor_prescription.class);
                            c.putExtra("p_name",p_n);
                            c.putExtra("p_num",ph);
                            c.putExtra("spd",o);
                            startActivity(c);
                        }
                        return true;
                    }
                });
                popup.show();
            }
        });
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(getApplicationContext(),doctor_login.class);
                startActivity(logout);
            }
        });
    }
}