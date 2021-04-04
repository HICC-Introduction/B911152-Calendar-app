package com.example.calendar_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceStare){
        super.onCreate(savedInstanceStare);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1500);
    }
    protected void onPause(){
        super.onPause();
        finish();
    }
}