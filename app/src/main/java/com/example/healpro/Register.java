package com.example.healpro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    Button reg, verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        reg=(Button)findViewById(R.id.register2);
        verify=(Button)findViewById(R.id.verify);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nam,username,phone;
                reg=(Button) findViewById(R.id.register2);
                nam=(EditText) findViewById(R.id.edit_name);
                String n=nam.getText().toString();
                username=(EditText)findViewById(R.id.edit_username);
                String uname=username.getText().toString();
                phone=(EditText)findViewById(R.id.phone_no);
                String ph=phone.getText().toString();
                EditText email=(EditText) findViewById(R.id.em);
                String em=email.getText().toString();
                EditText pd,cpd;
                pd=(EditText) findViewById(R.id.pd);
                cpd=(EditText) findViewById(R.id.cpd);
                String pwd=pd.getText().toString();
                String cpwd  =cpd.getText().toString();
                RadioGroup rg = (RadioGroup) findViewById(R.id.gender);
                if(!n.isEmpty() && !uname.isEmpty())
                {
                    if (ph.length()== 10 && ph.charAt(0)!='0')
                    {
                        if (!em.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(em).matches())
                        {
                            if (pwd.length() >= 8)
                            {
                                if(pwd.equals(cpwd))
                                {
                                    if (rg.getCheckedRadioButtonId()==-1) {
                                        RadioButton g3=(RadioButton)findViewById(R.id.others);
                                        g3.setError("Gender not selected");

                                    }
                                    else {
                                        reg.setAlpha(1.0f);
                                        reg.setClickable(true);
                                    }
                                }
                                else
                                {
                                    pd.setError("Passwords do not match");
                                    cpd.setError("Passwords do not match");
                                }
                            }
                            else {
                                pd.setError("Password must be atleast 8 characters long");
                            }
                        } else {
                            email.setError("Invalid email ");
                        }
                    } else {
                       phone.setError("Invalid phone number");
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "All fields are mandatory!", Toast.LENGTH_SHORT).show();
                }
            }
        });
            reg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                        Intent home=new Intent(getApplicationContext(),Home.class);
                        startActivity(home);
                }
            });

    }
}