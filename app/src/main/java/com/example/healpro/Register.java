package com.example.healpro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    Button reg,verify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nam,username;
                reg=(Button) findViewById(R.id.register2);
                nam=(EditText) findViewById(R.id.edit_name);
                String n=nam.getText().toString();
                username=(EditText)findViewById(R.id.edit_username);
                String uname=username.getText().toString();
            }
        });
            reg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(peekAvailableContext());
                        alertDialogBuilder.setTitle("Registration");
                        alertDialogBuilder.setIcon(R.drawable.logo);
                        alertDialogBuilder.setMessage("Do you want to continue ?");
                        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent home = new Intent(getApplicationContext(), Home.class);
                            }
                        });
                        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "You chose not to continue", Toast.LENGTH_SHORT).show();
                            }
                        });
                        alertDialogBuilder.setCancelable(false);
                        AlertDialog alertdialog = alertDialogBuilder.create();
                        alertdialog.show();
                }
            });

    }
}