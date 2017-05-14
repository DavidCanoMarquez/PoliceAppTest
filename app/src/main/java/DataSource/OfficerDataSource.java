package DataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.david.police_app.NewDataBaseHelper;
import com.example.david.police_app.NewPoliceDB;

import java.util.ArrayList;
import java.util.List;

import Constructors.Officer;

/**
 * Created by David on 27.04.2017.
 */

public class OfficerDataSource {

    private SQLiteDatabase db;
    private Context context;

    public OfficerDataSource(Context context){
        NewDataBaseHelper sqliteHelper = NewDataBaseHelper.getInstance(context);
        db = sqliteHelper.getWritableDatabase();
        this.context = context;

    }

    /**
     * Insert a new officer
     */
    public long createOfficer(Officer officer){
        long id;
        ContentValues values = new ContentValues();
        values.put(NewPoliceDB.TableOfficer.OFFICER_FIRSTNAME, officer.getFirstname());
        values.put(NewPoliceDB.TableOfficer.OFFICER_LASTNAME, officer.getLastname());
        values.put(NewPoliceDB.TableOfficer.OFFICER_PHONE, officer.getPhone());
        values.put(NewPoliceDB.TableOfficer.OFFICER_TYPE, officer.getType());
        values.put(NewPoliceDB.TableOfficer.OFFICER_ID_TEAM, officer.getId_Team());


        id = this.db.insert(NewPoliceDB.TableOfficer.TABLE_OFFICER, null, values);

        return id;
    }

    /**
     * Find one Officer by Id
     */
    public Officer getOfficerById(int id){
        String sql = "SELECT * FROM " + NewPoliceDB.TableOfficer.TABLE_OFFICER +
                " WHERE " + NewPoliceDB.TableOfficer.OFFICER_ID + " = " + id;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

       Officer officer = new Officer();
        officer.setId_Officer(cursor.getInt(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_ID)));
        officer.setFirstname(cursor.getString(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_FIRSTNAME)));
        officer.setLastname(cursor.getString(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_LASTNAME)));
        officer.setPhone(cursor.getString(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_PHONE)));
        officer.setType(cursor.getString(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_TYPE)));
        officer.setId_Team(cursor.getInt(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_ID_TEAM)));


        return officer;
    }

    /**
     * Find one Officer by team
     */
    public Officer getOfficerByTeam(int id_team){
        String sql = "SELECT * FROM " + NewPoliceDB.TableOfficer.TABLE_OFFICER +
                " WHERE " + NewPoliceDB.TableOfficer.OFFICER_ID_TEAM + " = " + id_team;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        Officer officer = new Officer();
        officer.setId_Officer(cursor.getInt(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_ID)));
        officer.setFirstname(cursor.getString(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_FIRSTNAME)));
        officer.setLastname(cursor.getString(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_LASTNAME)));
        officer.setPhone(cursor.getString(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_PHONE)));
        officer.setType(cursor.getString(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_TYPE)));
        officer.setId_Team(cursor.getInt(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_ID_TEAM)));

        return officer;
    }

    /**
     * Get all Officers
     */
    public List<Officer> getAllOfficers(){
        List<Officer> officers = new ArrayList<Officer>();
        String sql = "SELECT * FROM " + NewPoliceDB.TableOfficer.TABLE_OFFICER + " ORDER BY " + NewPoliceDB.TableOfficer.OFFICER_LASTNAME;

        Cursor cursor = this.db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                Officer officer = new Officer();
                officer.setId_Officer(cursor.getInt(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_ID)));
                officer.setFirstname(cursor.getString(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_FIRSTNAME)));
                officer.setLastname(cursor.getString(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_LASTNAME)));
                officer.setPhone(cursor.getString(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_PHONE)));
                officer.setType(cursor.getString(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_TYPE)));
                officer.setId_Team(cursor.getInt(cursor.getColumnIndex(NewPoliceDB.TableOfficer.OFFICER_ID_TEAM)));


                officers.add(officer);
            } while(cursor.moveToNext());
        }

        return officers;
    }


























    /**
     * Insert a new officer

    public long createOfficer(Officer officer){
        long id;
        ContentValues values = new ContentValues();
        values.put(NewPoliceDB.TableOfficer.OFFICER_FIRSTNAME, officer.getFirstname());
        values.put(NewPoliceDB.TableOfficer.OFFICER_LASTNAME, officer.getLastname());
        values.put(NewPoliceDB.TableOfficer.OFFICER_PHONE, officer.getPhone());
        values.put(NewPoliceDB.TableOfficer.OFFICER_TYPE, officer.getType());
        values.put(NewPoliceDB.TableOfficer.OFFICER_ID_TEAM, officer.getId_Team());


        id = this.db.insert(NewPoliceDB.TableOfficer.TABLE_OFFICER, null, values);

        return id;
    }
     */



    /**
     *  Update a Officer
     */
    public int updateOfficer(Officer officer){
        ContentValues values = new ContentValues();
        values.put(NewPoliceDB.TableOfficer.OFFICER_FIRSTNAME, officer.getFirstname());
        values.put(NewPoliceDB.TableOfficer.OFFICER_LASTNAME, officer.getLastname());
        values.put(NewPoliceDB.TableOfficer.OFFICER_PHONE, officer.getPhone());
        values.put(NewPoliceDB.TableOfficer.OFFICER_TYPE, officer.getType());
        values.put(NewPoliceDB.TableOfficer.OFFICER_ID_TEAM, officer.getType());

            return this.db.update(NewPoliceDB.TableOfficer.TABLE_OFFICER, values, NewPoliceDB.TableOfficer.OFFICER_ID + " = ?",
                new String[] { String.valueOf(officer.getId_Officer()) });
    }

    /**
     * Delete a Officer - this will also delete all records
     * for the officer*/


    public void deleteOfficer(Officer officer) {

        //delete the officer
        this.db.delete(NewPoliceDB.TableOfficer.TABLE_OFFICER, NewPoliceDB.TableOfficer.OFFICER_PHONE + " = ?",
                new String[]{String.valueOf(officer.getPhone())});

    }

}
