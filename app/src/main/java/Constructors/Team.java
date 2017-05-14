package Constructors;

import java.io.Serializable;

/**
 * Created by David on 24.04.2017.
 */



public class Team implements Serializable {

    private long idTeam;
    private String TeamChief;
    private String teamComposant;

    public Team(){

    }
    public Team(long idTeam, String TeamChief, String teamComposant){

        this.idTeam = idTeam;
        this.TeamChief = TeamChief;
        this.teamComposant = teamComposant ;
    }

    public long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(long idTeam) {
        this.idTeam = idTeam;
    }

    public String getTeamChief() {
        return TeamChief;
    }

    public void setTeamChief(String teamChief) {
        TeamChief = teamChief;
    }

    public String getTeamComposant() {
        return teamComposant;
    }

    public void setTeamComposant(String teamComposant) {
        this.teamComposant = teamComposant;
    }





}
