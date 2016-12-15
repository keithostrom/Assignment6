package com.example.cisc.assignment6;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static SharedPreferences myPreferences;
    static SharedPreferences.Editor editor;

    final static String PREFS_FILE_NAME = "myprefs";
    final static String PREFS_ITEM_VALID = "item_valid"; //Are prefs valid?
    final static String PREFS_ITEM_MUTE = "item_mute";
    static boolean prefsAreValid;
    public static boolean soundEnabled;

    TextView textViewObjectSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myPreferences = getSharedPreferences(PREFS_FILE_NAME,MODE_PRIVATE);
        prefsAreValid = myPreferences.getBoolean(PREFS_ITEM_VALID,false);
        editor = myPreferences.edit();

        if( prefsAreValid == false) {
            // Write Default preferences
            editor.putBoolean(PREFS_ITEM_VALID,true);
            editor.putBoolean(PREFS_ITEM_MUTE,true);
            editor.commit();
        }
        soundEnabled = myPreferences.getBoolean(PREFS_ITEM_MUTE,false);

        textViewObjectSound = (TextView) findViewById(R.id.textViewSound);
        if( soundEnabled ) {
            textViewObjectSound.setText("Sound is ON");
        }
        else {
            textViewObjectSound.setText("Sound is OFF");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout, menu);
        return true;
    } // End onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        Intent theIntent;

        switch ( item.getItemId()) {
            case R.id.item_mySettings:
                theIntent = new Intent(this,MySettings.class);
                startActivity(theIntent);
                return true;

            case R.id.item_settings:
                theIntent = new Intent(this,SettingsActivity.class);
                startActivity(theIntent);
                return true;

            case R.id.help:
                Toast.makeText(this,"You selected Help",Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    } // End onOptionsItemSelected

} // End class MainActivity
