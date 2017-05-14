package com.example.david.police_app;


import android.provider.BaseColumns;


public class NewPoliceDB {

    public static abstract class TableIntervention implements BaseColumns {
        //Table name
        public static final String TABLE_INTERVENTION = "Intervention";


        //TABLE FOR INTERVENTION
        public static final String INTERVENTION_ID = "Intervention_id";
        public static final String INTERVENTION_NAME = "Intervention_name";
        public static final String INTERVENTION_PRIORITY = "Intervention_priority";
        public static final String INTERVENTION_DESCRIPTION = "Intervention_description";
        public static final String INTERVENTION_DATE_BEGIN = "Intervention_date_begin";
        public static final String INTERVENTION_DATE_END = "Intervention_date_end";
        public static final String INTERVENTION_LOCALISATION = "Intervention_localisation";



        //Table intervention create statement
        public static final String CREATE_TABLE_INTERVENTION = "CREATE TABLE "
                + TABLE_INTERVENTION + "("
                + INTERVENTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + INTERVENTION_NAME + " TEXT, "
                + INTERVENTION_PRIORITY + " TEXT, "
                + INTERVENTION_DESCRIPTION + " TEXT, "
                + INTERVENTION_DATE_BEGIN + " TEXT, "
                + INTERVENTION_DATE_END + " TEXT, "
                + INTERVENTION_LOCALISATION + " TEXT "
                + " );";

    }

    public static abstract class TableTeam implements BaseColumns {
        //Table name
        public static final String TABLE_TEAM = "Team";

        //TABLE FOR TEAM
        public static final String TEAM_ID = "idTeam";
        public static final String TEAM_CHIEF = "Team_chief";
        public static final String TEAM_COMPOSANTS = "Team_composants";

        public static final String TEAM_ID_INTERVENTION = "Team_id_intervention";


        //Table team create statement
        public static final String CREATE_TABLE_TEAM = "CREATE TABLE "
                + TABLE_TEAM + "("
                + TEAM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + TEAM_CHIEF + " TEXT, "
                + TEAM_COMPOSANTS + " INTEGER, "
                + TEAM_ID_INTERVENTION + " INTEGER, "
                + "FOREIGN KEY("+ TEAM_ID_INTERVENTION + ") REFERENCES "
                + TableIntervention.TABLE_INTERVENTION + "(" + TableIntervention.INTERVENTION_ID +") "
                + ");";
    }

    public static abstract class TableOfficer implements BaseColumns {

        //Table name
        public static final String TABLE_OFFICER = "Officer";

        //TABLE FOR OFFICERS
        public static final String OFFICER_ID = "idOfficer";
        public static final String OFFICER_FIRSTNAME = "Officer_firstname";
        public static final String OFFICER_LASTNAME = "Officer_lastname";
        public static final String OFFICER_PHONE = "Officer_phone";
        public static final String OFFICER_TYPE = "Officer_type";

        public static final String OFFICER_ID_TEAM = "Officer_id_team";
        public static final String OFFICER_ID_INTERVENTION = "Officer_id_intervention";


        //Table officer create statement

        public static final String CREATE_TABLE_OFFICER = "CREATE TABLE "
                + TABLE_OFFICER + "("
                + OFFICER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + OFFICER_FIRSTNAME + " TEXT, "
                + OFFICER_LASTNAME + " TEXT, "
                + OFFICER_PHONE + " TEXT, "
                + OFFICER_TYPE + " TEXT, "
                + OFFICER_ID_TEAM + " INTEGER, "
                + OFFICER_ID_INTERVENTION + " INTEGER, "
                + "FOREIGN KEY("+ OFFICER_ID_TEAM + ") REFERENCES "
                + TableTeam.TABLE_TEAM + "(" + TableTeam.TEAM_ID +"), "
                + "FOREIGN KEY("+ OFFICER_ID_INTERVENTION + ") REFERENCES "
                + TableIntervention.TABLE_INTERVENTION + "(" + TableIntervention.INTERVENTION_ID +") "
                + ");";
    }
}