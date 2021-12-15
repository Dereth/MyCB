package com.mycb.MyCB.object.modification;

public class ModifyTeamForm extends ModifyForm {

    private String teamId;
    private String name;
    private String wins;
    private String losses;
    private String conference;

    @Override
    public Object[] runInsert() {
        this.query = "INSERT INTO Teams VALUES(?, ?, ?, ?, ?);";
        return new Object[] {teamId, name, wins, losses, conference};
    }

    @Override
    public Object[] runUpdate() {
        this.query = "UPDATE Teams SET name = ?, wins = ?, losses = ?, conference = ? WHERE team_id = ?";
        return new Object[] {name, wins, losses, conference, teamId};
    }

    @Override
    public Object[] runDelete() {
        this.query = "DELETE FROM Teams WHERE team_id = ?;";
        return new Object[] {teamId};
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }
}
