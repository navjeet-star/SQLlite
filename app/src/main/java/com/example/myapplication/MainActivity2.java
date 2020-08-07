package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int s= getIntent().getIntExtra("value",1);//0
        Log.e("ssss", String.valueOf(s));

        String ss= getIntent().getStringExtra("value");//null
        Log.e("ssss", String.valueOf(ss));

        int sss= Integer.parseInt(getIntent().getStringExtra("value"));//err
        Log.e("ssss", String.valueOf(sss));
        //ssss
    }
}