package com.example.healpro;

import androidx.appcompat.app.AppCompatActivity;

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

public class login extends AppCompatActivity {
    TextView marq;
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
                if(name.equals("user") && password.equals("user")){
                Intent activity2Intent = new Intent(getApplicationContext(), Home.class);
                startActivity(activity2Intent);}
                else{
                    Toast.makeText(getApplicationContext(), "Invalid credentials, please verify!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}