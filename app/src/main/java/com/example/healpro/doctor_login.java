package com.example.healpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class doctor_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);
        Button login=(Button) findViewById(R.id.d_login);
        EditText uid=(EditText)findViewById(R.id.d_uid);
        EditText upd=(EditText)findViewById(R.id.d_pd);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=uid.getText().toString();
                String pd = upd.getText().toString();
                if(id.equals("doctor") && pd.equals("doctor"))
                {
                    String name="John";
                    Intent doctor_home = new Intent(getApplicationContext(),doctor_home.class);
                    doctor_home.putExtra("Dr. ",name);
                    startActivity(doctor_home);
                }
                else
                {
                    upd.setError("Wrong credentials!");
                }
            }
        });
    }
}