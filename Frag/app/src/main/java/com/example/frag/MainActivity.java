package com.example.frag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    one a;
    two b;
    int disp=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a=new one();
        b=new two();
        FragmentManager fgm = getSupportFragmentManager();
        FragmentTransaction fgt=fgm.beginTransaction();
        fgt.add(R.id.clayout,a);
        fgt.commit();
        disp=1;

    }

    public void fragChange(View view) {
        FragmentManager fgm = getSupportFragmentManager();
        FragmentTransaction fgt=fgm.beginTransaction();

        if(disp==1)
        {
            fgt.replace(R.id.clayout,b);
            disp=2;
        }
        else
        {
            fgt.replace(R.id.clayout,a);
            disp=1;
        }
        fgt.commit();
    }
}