package com.example.david.police_app;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Constructors.Officer;
import Constructors.Team;
import DataSource.OfficerDataSource;
import DataSource.TeamDataSource;


public class DisplayNewOfficerActivity extends AppCompatActivity {
    private EditText fn,ln,ph;
    private String type="";
    private int id;
    private RadioButton officer_button,detective_button,sergeant_button,lieutenant_button,captain_button;
    private OfficerDataSource ods;
    private TeamDataSource tds;
    private Officer officer;
    private EditText txtLastname,txtFirstname,txtPhone;
    private TextView selectTeam,selectType ;
    private RadioGroup rgType;
    private RadioGroup team;
    private LinearLayout linearLayout,llt;
    private NewDataBaseHelper db;
    private CheckBox button;
    private List<Team> teams;
    private List<Officer> officers;
    private Intent intent;
    private List<CheckBox> rbl;
    private CheckBox cb;
    private String sel;
    private Officer o1;
    private String firstname,lastname,phone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newofficer_activity);

        linearLayout = (LinearLayout) findViewById(R.id.team);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        db = new NewDataBaseHelper(this);
        TeamDataSource tds = new TeamDataSource(this);

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
    public void submitOfficer(View view) {


        intent = new Intent(this, DisplayOfficersActivity.class);

        OfficerDataSource ods = new OfficerDataSource(this);

        officers = new ArrayList<Officer>();

        officers = ods.getAllOfficers();

        id = officers.size();

        selectTeam = (TextView) findViewById(R.id.selectTeam);
        selectType = (TextView) findViewById(R.id.fn);

        fn = (EditText) findViewById(R.id.fn);
        firstname = fn.getText().toString();

        ln = (EditText) findViewById(R.id.ln);
        lastname = ln.getText().toString();

        ph = (EditText) findViewById(R.id.ph);
        phone = ph.getText().toString();

        if (fn.getText().length()==0){
            fn.setError("Please enter a firstname");
            return;
        }

        if (ln.getText().length()==0){
            ln.setError("Please enter a lastname");
            return;
        }

        if (ph.getText().length()==0){
            ph.setError("Please enter a valable Phone");
            return;
        }
        officer_button = (RadioButton) findViewById(R.id.officer_button);

        detective_button = (RadioButton) findViewById(R.id.detective_button);

        sergeant_button = (RadioButton) findViewById(R.id.sergeant_button);

        lieutenant_button = (RadioButton) findViewById(R.id.lieutenant_button);

        captain_button = (RadioButton) findViewById(R.id.captain_button);

        type ="";
        if(officer_button.isChecked());
        {
            type = "Officer";
        }
        if(detective_button.isChecked())
        {
            type = "Detective";
        }
        if(sergeant_button.isChecked())
        {
            type = "Sergeant";
        }
        if(lieutenant_button.isChecked())
        {
            type = "Lieutenant";
        }
        if(captain_button.isChecked())
        {
            type = "Captain";
        }


        rbl = new ArrayList<CheckBox>();///////////////////////////////////////////


        llt = (LinearLayout) findViewById(R.id.team);



        for(int i = 0; i < llt.getChildCount(); i++){
            cb = (CheckBox)llt.getChildAt(i);
            sel = cb.getText().toString();


            int idTeam = Integer.parseInt(sel);

            if(cb.isChecked()){
                o1 = new Officer(id, firstname, lastname,
                        phone, type,idTeam);

                ods.createOfficer(o1);

            }



        }


        startActivity(intent);


    }


}