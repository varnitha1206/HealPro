package com.example.healpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class doctor_prescription extends AppCompatActivity {
TextView t;
TableLayout tb;
ImageButton imb;
Button finish;
DBhandler dBhandler;
int num1=0,num2=100;
int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_prescription);
        Intent p=getIntent();
        String patient_name = p.getStringExtra("p_name");
        String ph = p.getStringExtra("p_num");
        t=(TextView) findViewById(R.id.p_details);
        t.setText(patient_name);
        tb=(TableLayout) findViewById(R.id.table);
        imb= (ImageButton) findViewById(R.id.add);
        finish=(Button)findViewById(R.id.button4);
        dBhandler = new DBhandler(doctor_prescription.this);
        imb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                TableRow tr = new TableRow(getApplicationContext());
                EditText n1 = new EditText(getApplicationContext());
                EditText n2 = new EditText(getApplicationContext());
                num1++;
                num2++;
                n1.setId(num1);
                n2.setId(num2);
                tr.addView(n1);
                tr.addView(n2);
                tb.addView(tr, new TableLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int c=1,number1=1,number2=101;
                StringBuilder prep=new StringBuilder();
                while(c<=count&&number1<=num1&& number2<=num2)
                {
                    EditText e1=(EditText) findViewById(number1);
                    EditText e2 = (EditText) findViewById(number2);
                    if(!e1.getText().toString().isEmpty()&& !e2.getText().toString().isEmpty()) {
                        prep.append(e1.getText().toString());
                        prep.append(" ");
                        prep.append(e2.getText().toString() + "\n");
                    }
                    c++;
                    number1++;number2++;
                }
                dBhandler.addPrescriptions(patient_name,prep.toString(),ph);
                String x = dBhandler.finish(patient_name,ph);
                if(x.equals("-1")){
                    Toast.makeText(getApplicationContext(), "An error occurred!", Toast.LENGTH_SHORT).show();
                }
                else
                {
//                    Toast.makeText(getApplicationContext(), x, Toast.LENGTH_SHORT).show();
                    Intent doctor_home = new Intent(getApplicationContext(), doctor_home.class);
                    doctor_home.putExtra("spd", Integer.valueOf(x)+1);
                    startActivity(doctor_home);
                }
            }
        });
    }
}