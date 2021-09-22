package com.sha66.madprproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {
    private Intent k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
         k = new Intent(this,MainActivity.class);
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               startActivity(k);
               finish();
           }
       },2500);
    }


    }
