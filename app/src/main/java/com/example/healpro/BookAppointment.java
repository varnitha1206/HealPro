package com.example.healpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookAppointment extends AppCompatActivity {
TextView t1;
EditText e1,e2,e3;
String pn,pg, page,phone;
DBhandler dBhandler;
int cid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        Intent in=getIntent();
        String c= in.getStringExtra("Concern : ");
        cid=in.getIntExtra("cid",0);
        t1=(TextView) findViewById(R.id.concern);
        t1.setText("Concern specified : "+c);
        Button book=(Button)findViewById(R.id.submit_appointment);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spd = in.getStringExtra("specialist");
                e1=(EditText)findViewById(R.id.p_name);
                e2=(EditText)findViewById(R.id.p_age);
                e3=(EditText)findViewById(R.id.p_phone);
                pn=e1.getText().toString();
                page=(e2.getText().toString());
                RadioGroup pr=(RadioGroup)findViewById(R.id.radioGroup);
                int x=(pr.getCheckedRadioButtonId());
                RadioButton pgb=(RadioButton)findViewById(x);
                pg=pgb.getText().toString();
                phone = (e3.getText().toString());
                if(!pn.isEmpty() && !page.isEmpty() && !pg.isEmpty() && !phone.isEmpty() && phone.length()==10){
                dBhandler = new DBhandler(BookAppointment.this);
                dBhandler.addConsult(pn,page,spd,pg,phone);
                cid = dBhandler.addmap(cid,pn,phone);
                Toast.makeText(getApplicationContext(), "Thank you for reaching out to us! We shall contact you in the next 10-15 mins", Toast.LENGTH_SHORT).show();
                Intent ni=new Intent(getApplicationContext(),Home.class);
                ni.putExtra("cid",cid);
                startActivity(ni);}
                else
                {
                    Toast.makeText(getApplicationContext(), "Please enter all valid details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}