package DataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.david.police_app.NewDataBaseHelper;
import com.example.david.police_app.NewPoliceDB;

import java.util.ArrayList;
import java.util.List;

import Constructors.Team;

public class TeamDataSource {
    private SQLiteDatabase db;
    private Context context;

    public TeamDataSource(Context context) {
        NewDataBaseHelper sqliteHelper = NewDataBaseHelper.getInstance(context);
        db = sqliteHelper.getWritableDatabase();
        this.context = context;
    }

    /**
     * Insert a new team
     */
    public long createTeam(Team team) {
        long id;
        ContentValues values = new ContentValues();
        values.put(NewPoliceDB.TableTeam.TEAM_ID, team.getIdTeam());
        values.put(NewPoliceDB.TableTeam.TEAM_CHIEF, team.getTeamChief());
        values.put(NewPoliceDB.TableTeam.TEAM_COMPOSANTS, team.getTeamComposant());

        id = this.db.insert(NewPoliceDB.TableTeam.TABLE_TEAM, null, values);

        return id;
    }

    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<Team>();
        String sql = "SELECT * FROM " + NewPoliceDB.TableTeam.TABLE_TEAM + " ORDER BY " + NewPoliceDB.TableTeam.TEAM_ID;

        Cursor cursor = this.db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                Team team = new Team();
                team.setIdTeam(cursor.getLong(cursor.getColumnIndex(NewPoliceDB.TableTeam.TEAM_ID)));
                team.setTeamChief(cursor.getString(cursor.getColumnIndex(NewPoliceDB.TableTeam.TEAM_CHIEF)));
                team.setTeamComposant(cursor.getString(cursor.getColumnIndex(NewPoliceDB.TableTeam.TEAM_COMPOSANTS)));

                teams.add(team);
            } while (cursor.moveToNext());
        }

        return teams;
    }

    /**
     * Find one Team by Id
     */
    public Team getTeamById(int id) {
        String sql = "SELECT * FROM " + NewPoliceDB.TableTeam.TABLE_TEAM +
                " WHERE " + NewPoliceDB.TableTeam.TEAM_ID + " = " + id;

        Cursor cursor = this.db.rawQuery(sql, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Team team = new Team();
        team.setIdTeam(cursor.getLong(cursor.getColumnIndex(NewPoliceDB.TableTeam.TEAM_ID)));
        team.setTeamChief(cursor.getString(cursor.getColumnIndex(NewPoliceDB.TableTeam.TEAM_CHIEF)));
        team.setTeamComposant(cursor.getString(cursor.getColumnIndex(NewPoliceDB.TableTeam.TEAM_COMPOSANTS)));

        return team;
    }
    /**
     *  Update a Team
     */
    public void updateTeam(Team team){

        ContentValues values = new ContentValues();
        values.put(NewPoliceDB.TableTeam.TEAM_ID, team.getIdTeam());
        values.put(NewPoliceDB.TableTeam.TEAM_CHIEF, team.getTeamChief());

        this.db.update(NewPoliceDB.TableTeam.TABLE_TEAM, values, NewPoliceDB.TableTeam.TEAM_ID + " = ?",
                new String[] { String.valueOf(team.getIdTeam()) });
    }



    /**
     * Delete a Team
     */
    public void deleteTeam(long id) {
        this.db.delete(NewPoliceDB.TableTeam.TABLE_TEAM, NewPoliceDB.TableTeam.TEAM_ID + " = ?",
                new String[]{String.valueOf(id)});
    }

//voir!!!!!!!!!
    public String[] getAllSpinnerContent(){

        String query = "SELECT"+NewPoliceDB.TableTeam.TEAM_ID+" FROM " + NewPoliceDB.TableTeam.TABLE_TEAM;
        Cursor cursor = this.db.rawQuery(query, null);
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if(cursor.moveToFirst()){
            do{
                String word = cursor.getString(cursor.getColumnIndexOrThrow("content"));
                spinnerContent.add(word);
            }while(cursor.moveToNext());
        }
        cursor.close();

        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray(allSpinner);

        return allSpinner;
    }



}
