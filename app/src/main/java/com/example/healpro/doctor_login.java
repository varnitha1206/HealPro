package com.example.healpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class doctor_login extends AppCompatActivity {
    private DBhandler dBhandler;
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
                if(!id.isEmpty()&&!pd.isEmpty())
                {
                    dBhandler = new DBhandler(doctor_login.this);
                    dBhandler.addDocs();
                    int o = dBhandler.readDoctor(id, pd);
                    if(o==1) {
                        String name = "John";
                        Intent doctor_home = new Intent(getApplicationContext(), doctor_home.class);
                        doctor_home.putExtra("Dr. ", name);
                        startActivity(doctor_home);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Invalid Credentials, Retry!", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    upd.setError("Wrong credentials!");
                }
            }
        });
    }
}