package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText txtMobile, txtMessage;
    Button btnSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMobile = (EditText)findViewById(R.id.txtnum);
        txtMessage = (EditText)findViewById(R.id.txtmsg);
        btnSms = (Button)findViewById(R.id.bSend);

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                     SmsManager smgr = SmsManager.getDefault();
                    smgr.sendTextMessage(txtMobile.getText().toString(),
                            null,txtMessage.getText().toString(),
                            null, null);


                    Toast.makeText(MainActivity.this, "SMS SENT Successfully ", Toast.LENGTH_SHORT).show();
                    txtMobile.setText("");
                    txtMessage.setText("");
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "SMS Failed to Send, " +
                            "Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}