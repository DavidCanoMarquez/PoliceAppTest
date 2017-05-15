package com.example.david.police_app;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import Constructors.Intervention;
import DataSource.InterventionDataSource;
import DataSource.OfficerDataSource;
import DataSource.TeamDataSource;


public class DisplayInterventionsActivity extends AppCompatActivity {

    InterventionDataSource ids;
    public static final String EXTRA_MESSAGE2 = "com.example.david.police_app.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interventions_activity);


        // Create a LinearLayout element
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);



        NewDataBaseHelper db = new NewDataBaseHelper(this);
        OfficerDataSource ods = new OfficerDataSource(this);
        TeamDataSource tds = new TeamDataSource(this);
        InterventionDataSource ids = new InterventionDataSource(this);
        List<Intervention> interventions = new ArrayList<Intervention>();


        //insert interventions
/**
        Intervention i1  = new Intervention(1, "a", "b", "c", "d", "e", "f", 3, 2);
        ids.createIntervention(i1);


**/
        interventions=ids.getAllInterventions();

        for (int i = 0; i < interventions.size(); i++) {

            // Add Buttons
            Button button = new Button(this);
            String s = interventions.get(i).getInterName();
            button.setText(s);
            for(int j=i+1;j<interventions.size();j++){
                if(interventions.get(i).getInterName().equals(interventions.get(j).getInterName())){

                    i=i+1;
                }

            }
            linearLayout.addView(button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showInfosIntervention(view);
                }
            });

        }

    }

    /** Called when the user taps the add_Intervention button**/
    public void showNewIntervention(View view){
        //show officers
        Intent intent = new Intent(this, DisplayNewInterventionActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the show_intervention button**/
    public void showInfosIntervention(View view){
        //show interventions
        Intent intent = new Intent(this, DisplayInfoInterventionActivity.class);
        String message = String.valueOf(((Button)view).getText());
        intent.putExtra(EXTRA_MESSAGE2, message);
        startActivity(intent);
    }

}
