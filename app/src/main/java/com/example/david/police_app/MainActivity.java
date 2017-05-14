package com.example.david.police_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        changeLanguage(this,sharedPrefs.getString("pref_lang", "en"));
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.action_settings){
            Intent intent = new Intent(this,SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void changeLanguage(Context context, String lang){
        Locale myLocale = new Locale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.setLocale(myLocale);
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
    }


    /** Called when the user taps the officers button**/
    public void showOfficers(View view){
        //show officers
        Intent intent = new Intent(this, DisplayOfficersActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the team button**/
    public void showTeams(View view){
        //show teams
        Intent intent = new Intent(this, DisplayTeamsActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the intervention button**/
    public void showInterventions(View view){
        //show interventions
        Intent intent = new Intent(this, DisplayInterventionsActivity.class);
        startActivity(intent);
    }

    /** Called when user taps one Officer button**/
    public void showOfficer(View view) {
        // Do something in response to button
    }
}
