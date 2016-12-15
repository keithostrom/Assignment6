package com.example.cisc.assignment6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //
        //    Waste 5 seconds
        //
        //  (Normally this delay would be from init code instead)
        //
        long startMilliseconds;
        long nowMilliseconds;
        startMilliseconds = System.currentTimeMillis();
        nowMilliseconds = startMilliseconds;
        while( nowMilliseconds - startMilliseconds < 5000) {
            nowMilliseconds = System.currentTimeMillis();
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}
