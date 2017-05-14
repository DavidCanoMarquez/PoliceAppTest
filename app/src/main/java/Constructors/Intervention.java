package Constructors;

/**
 * Created by David on 27.04.2017.
 */

public class Intervention {

    private long idIntervention;
    private String interName;
    private String interPriority;
    private String intDescription;
    private String dateBegin;
    private String dateEnd;
    private String localisation;
    private long idTeam;

    public Intervention(){

    }

    public Intervention(long idIntervention, String interName, String interPriority, String intDescription, String DateBegin, String DateEnd, String Localisation, long idTeam){

        this.idIntervention = idIntervention;
        this.interName = interName;
        this.interPriority = interPriority;
        this.intDescription = intDescription;
        this.dateBegin = DateBegin;
        this.dateEnd = DateEnd;
        this.localisation = Localisation;
        this.idTeam = idTeam;
    }

    public long getIdIntervention() {
        return idIntervention;
    }

    public void setIdIntervention(long idIntervention) {
        this.idIntervention = idIntervention;
    }

    public String getInterName() {
        return interName;
    }

    public void setInterName(String interName) {
        this.interName = interName;
    }

    public String getInterPriority() {
        return interPriority;
    }

    public void setInterPriority(String interPriority) {
        this.interPriority = interPriority;
    }

    public String getIntDescription() {
        return intDescription;
    }

    public void setIntDescription(String intDescription) {
        this.intDescription = intDescription;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(long idTeam) {
        this.idTeam = idTeam;
    }



}
