package com.example.cisc.assignment6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MySettings extends AppCompatActivity implements View.OnClickListener{

    Button buttonOK;
    Switch mySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_settings);

        buttonOK = (Button) findViewById(R.id.buttonMySettingsOK);
        buttonOK.setOnClickListener(this);

        // Find switch and set to current state from MainActivity
        mySwitch = (Switch) findViewById(R.id.switch1);
        mySwitch.setOnClickListener(this);
        mySwitch.setChecked(MainActivity.soundEnabled);

    } // End onCreate()


    @Override
    public void onClick(View view) {
        switch (view.getId() ) {
            case R.id.buttonMySettingsOK:
                Intent toMainIntent = new Intent(this,MainActivity.class);
                startActivity(toMainIntent);
                break;
            case R.id.switch1:
                MainActivity.soundEnabled = mySwitch.isChecked();
                MainActivity.editor.putBoolean(MainActivity.PREFS_ITEM_MUTE,MainActivity.soundEnabled);
                MainActivity.editor.commit();
                break;
        }
    }
} // End class MySettings
