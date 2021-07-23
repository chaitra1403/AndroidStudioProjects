package com.example.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText opr1;
    private EditText opr2;
    private Button btnadd;
    private Button btnsub;
    private Button btnmul;
    private Button btndiv;
    private Button btnclr;
    private TextView txtresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opr1=findViewById(R.id.ed1);
        opr2=findViewById(R.id.ed2);
        btnadd=findViewById(R.id.b1);
        btnsub=findViewById(R.id.b2);
        btnmul=findViewById(R.id.b3);
        btndiv=findViewById(R.id.b4);
        btnclr=findViewById(R.id.b5);
        txtresult=(TextView) findViewById(R.id.tv);
        //add
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((opr1.getText().length()>0) && (opr2.getText().length()>0))
                {
                    double oper1=Double.parseDouble(opr1.getText().toString());
                    double oper2=Double.parseDouble(opr2.getText().toString());
                    double result=oper1+oper2;
                    txtresult.setText(Double.toString(result));
                }
                else
                {
                    Toast toast=Toast.makeText(MainActivity.this,"enter the requiered numbers",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        //sub
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((opr1.getText().length()>0) && (opr2.getText().length()>0))
                {
                    double oper1=Double.parseDouble(opr1.getText().toString());
                    double oper2=Double.parseDouble(opr2.getText().toString());
                    double result=oper1-oper2;
                    txtresult.setText(Double.toString(result));
                }
                else
                {
                    Toast toast=Toast.makeText(MainActivity.this,"enter requiered numbers",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((opr1.getText().length()>0) && (opr2.getText().length()>0))
                {
                    double oper1=Double.parseDouble(opr1.getText().toString());
                    double oper2=Double.parseDouble(opr2.getText().toString());
                    double result=oper1*oper2;
                    txtresult.setText(Double.toString(result));
                }
                else
                {
                    Toast toast=Toast.makeText(MainActivity.this,"enter requiered numbers",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((opr1.getText().length()>0) && (opr2.getText().length()>0))
                {
                    double oper1=Double.parseDouble(opr1.getText().toString());
                    double oper2=Double.parseDouble(opr2.getText().toString());
                    double result=oper1/oper2;
                    txtresult.setText(Double.toString(result));
                }
                else
                {
                    Toast toast=Toast.makeText(MainActivity.this,"enter requiered text",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr1.setText("");
                opr2.setText("");
                txtresult.setText("0.00");
                opr1.requestFocus();
            }
        });


    }
}