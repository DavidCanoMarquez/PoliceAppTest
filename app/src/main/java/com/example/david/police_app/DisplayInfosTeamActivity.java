package com.example.david.police_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import Constructors.Officer;
import Constructors.Team;
import DataSource.OfficerDataSource;
import DataSource.TeamDataSource;

/**
 * Created by David on 25.04.2017.
 */

public class DisplayInfosTeamActivity extends AppCompatActivity{



    private String teamchief,teamcomposants;
    //getTeamchief(); getTeamComposants
    private int id;
    private OfficerDataSource ods;
    private TeamDataSource tds;
    private RadioGroup chief;
    private List<Team> teams;
    private Team team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_team_activity);


        tds = new TeamDataSource(this);
        teams=tds.getAllTeams();
        Intent intent = getIntent();
           String message = intent.getStringExtra(DisplayTeamsActivity.EXTRA_MESSAGE1);
      Team  team = tds.getTeamById(Integer.parseInt(message));


        // Create a RadioGroup element
        chief = (RadioGroup) findViewById(R.id.chief);
        chief.setOrientation(RadioGroup.VERTICAL);
        RadioButton rbType;
        String teamChief;

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.chief);


        NewDataBaseHelper db = new NewDataBaseHelper(this);
        ods = new OfficerDataSource(this);
        List<Officer> officers = new ArrayList<Officer>();
        officers=ods.getAllOfficers();

        List<Team> teamsToShow = new ArrayList<Team>();
        teamsToShow=tds.getAllTeams();

        //boucle to show chiefs
        for (int i = 0; i < officers.size(); i++) {

            // Add RadioButtons
            RadioButton button = new RadioButton(this);
            String s =String.valueOf(officers.get(i).getLastname());

            button.setText(s.toUpperCase());
            String chief = team.getTeamChief();

            if(team.getTeamChief().toUpperCase().equals(s.toUpperCase()))
            button.setChecked(true);
            //boucle to show just one each officer
            for(int j=i+1;j<officers.size();j++){
                if(officers.get(i).getPhone().equals(officers.get(j).getPhone())){

                    i=i+1;
                }

            }
            radioGroup.addView(button);

        }



        officers = ods.getAllOfficers();

        for (int i = 0; i < officers.size(); i++) {

            // Add Buttons
            final RadioButton button = new RadioButton(this);
            int btnId = (int) officers.get(i).getId_Officer();
            String s = officers.get(i).getLastname();
            button.setText(s);
            button.setId(btnId);
            if(team.getTeamComposant().toUpperCase().equals(s.toUpperCase()))
                button.setChecked(true);


            for (int j = i + 1; j < officers.size(); j++) {
                if (officers.get(i).getPhone().equals(officers.get(j).getPhone())) {
                    i = i + 1;
                }

            }

            chief.addView(button);
        }




        // Create a LinearLayout element
        LinearLayout composants = (LinearLayout) findViewById(R.id.composants);

//boucle to show composants
        for (int i = 0; i < officers.size(); i++) {

            // Add RadioButtons
            CheckBox button = new CheckBox(this);
            String s =String.valueOf(officers.get(i).getLastname());

            button.setText(s.toUpperCase());
            //String composant = team.getTeamComposant();

            if(team.getTeamComposant().toUpperCase().equals(s.toUpperCase())) {
                //button.setChecked(true);
            }
            //boucle to show just one each officer
            for(int j=i+1;j<officers.size();j++){
                if(officers.get(i).getPhone().equals(officers.get(j).getPhone())){

                    i=i+1;
                }

            }
            composants.addView(button);

        }






    }
    public void deleteTeam(View view){


        Intent intent = new Intent(this, DisplayTeamsActivity.class);
       tds.deleteTeam(team);
        startActivity(intent);
    }
    public void updateTeam(View view){


        Intent intent = new Intent(this, DisplayTeamsActivity.class);
        startActivity(intent);
    }

}
