package com.example.healpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    TextView marq;
    private DBhandler dBhandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
       Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide);
        ImageView img=findViewById(R.id.heart);
        img.startAnimation(anim);
        anim.setRepeatCount(Animation.INFINITE);
        Button login=findViewById(R.id.d_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText n=(EditText)findViewById(R.id.d_uid);
                EditText pd=(EditText)findViewById(R.id.d_pd);
                String name=n.getText().toString();
                String password=pd.getText().toString();
                if(!name.isEmpty()&&!password.isEmpty()) {
                    dBhandler = new DBhandler(login.this);
                    int o = dBhandler.read(name, password);
                    if (o != 0) {
                        Intent activity2Intent = new Intent(getApplicationContext(), Home.class);
                        activity2Intent.putExtra("cid",o);
                        startActivity(activity2Intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid credentials, please verify!", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Enter Credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}