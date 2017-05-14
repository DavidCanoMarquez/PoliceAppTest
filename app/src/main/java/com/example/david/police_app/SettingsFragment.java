package com.example.david.police_app;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by Lionel on 03.05.2017.
 */

public class SettingsFragment extends PreferenceFragment{
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
