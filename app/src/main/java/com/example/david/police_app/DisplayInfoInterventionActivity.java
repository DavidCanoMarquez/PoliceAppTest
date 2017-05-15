package com.example.david.police_app;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import Constructors.Intervention;
import Constructors.Team;
import DataSource.InterventionDataSource;
import DataSource.TeamDataSource;


public class DisplayInfoInterventionActivity extends AppCompatActivity {

    private String iname,idateB,idateE,ilocalisation,idescription;
    private int id;
    private LinearLayout linearLayout,llt;
    //private RadioGroup team;
    private List<Team> teams;

    private NewDataBaseHelper db;
    private CheckBox button;
    private InterventionDataSource ids;
    private Intent intent;
    private List<Intervention> interventions;
    private Intervention intervention;
    private String type="";
    private List<CheckBox> rbl;
    private CheckBox cb;
    private String sel;
    private Intervention i1;
    private RadioButton hight,medium,low;
    private EditText name, description, dateB, dateE, localisation;
    private LinearLayout team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_intervention_activity);

        ids = new InterventionDataSource(this);
        interventions = ids.getAllInterventions();
        Intent intent = getIntent();
        String message = intent.getStringExtra(DisplayInterventionsActivity.EXTRA_MESSAGE2);

        intervention = ids.getInterventionById(Integer.parseInt(message));


        name = (EditText) findViewById(R.id.name);
        name.setText(intervention.getInterName());

        description = (EditText) findViewById(R.id.description);
        description.setText(intervention.getIntDescription());

        dateB = (EditText) findViewById(R.id.dateB);
        dateB.setText(intervention.getDateBegin());

        dateE = (EditText) findViewById(R.id.dateE);
        dateE.setText(intervention.getDateEnd());

        localisation = (EditText) findViewById(R.id.localisation);
        localisation.setText(intervention.getLocalisation());





        db = new NewDataBaseHelper(this);
        TeamDataSource tds = new TeamDataSource(this);

        linearLayout = (LinearLayout) findViewById(R.id.team);
        linearLayout.setOrientation(LinearLayout.VERTICAL);


        teams = new ArrayList<Team>();
        teams=tds.getAllTeams();

        for (int i = 0; i < teams.size(); i++) {

            button = new CheckBox(this);
            String s =String.valueOf(teams.get(i).getIdTeam());
            button.setText(s);

            linearLayout.addView(button);
        }

    }
    /** Called when officer click submit button */
    public void submitIntervention(View view) {


        intent = new Intent(this, DisplayInterventionsActivity.class);

        InterventionDataSource ids = new InterventionDataSource(this);

        interventions = new ArrayList<Intervention>();

        interventions = ids.getAllInterventions();

        id = interventions.size();

        name = (EditText) findViewById(R.id.name);
        iname = name.getText().toString();

        description = (EditText) findViewById(R.id.description);
        idescription = description.getText().toString();

        dateB = (EditText) findViewById(R.id.dateB);
        idateB = dateB.getText().toString();

        dateE = (EditText) findViewById(R.id.dateE);
        idateE = dateE.getText().toString();

        localisation = (EditText) findViewById(R.id.localisation);
        ilocalisation = localisation.getText().toString();



        if (name.getText().length()==0){
            name.setError("Please enter a name");
            return;
        }

        if (description.getText().length()==0){
            idescription="";

        }

        if (dateB.getText().length()==0){
            idateB ="";
            return;
        }
        if (dateB.getText().length()==0){
            idateB ="";
            return;
        }
        if (dateB.getText().length()==0){
            idateB ="";
            return;
        }
        if (localisation.getText().length()==0){
            ilocalisation ="";
            return;
        }
        hight = (RadioButton) findViewById(R.id.hight);

        medium = (RadioButton) findViewById(R.id.medium);

        low = (RadioButton) findViewById(R.id.low);



        type ="";
        if(hight.isChecked());
        {
            type = "hihgt";
        }
        if(medium.isChecked())
        {
            type = "medium";
        }
        if(low.isChecked())
        {
            type = "low";
        }
        if (type.length()==0){
            type = "low";

        }



        rbl = new ArrayList<CheckBox>();


        llt = (LinearLayout) findViewById(R.id.team);



        for(int i = 0; i < llt.getChildCount(); i++){
            cb = (CheckBox)llt.getChildAt(i);
            sel = cb.getText().toString();


            long idTeam = Integer.parseInt(sel);

            if(cb.isChecked()){
                i1 = new Intervention(id,iname,type,idescription,idateB,idateE,ilocalisation,idTeam);


                ids.createIntervention(i1);

            }



        }


        startActivity(intent);

    }

    public void deleteIntervention(View view){


        Intent intent = new Intent(this, DisplayInterventionsActivity.class);
        startActivity(intent);
    }
    public void updateIntervention(View view){


        Intent intent = new Intent(this, DisplayInterventionsActivity.class);
        startActivity(intent);
    }

}
