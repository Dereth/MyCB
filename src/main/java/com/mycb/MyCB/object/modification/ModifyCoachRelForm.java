package com.mycb.MyCB.object.modification;

public class ModifyCoachRelForm extends ModifyForm {

    private String coachId;
    private String teamId;

    @Override
    public Object[] runInsert() {
        this.query = "INSERT INTO CoachRel VALUES(?, ?);";
        return new Object[] {coachId, teamId};
    }

    @Override
    public Object[] runUpdate() {
        this.query = "UPDATE CoachRel SET team_id = ? WHERE coach_id = ?";
        return new Object[] {teamId, coachId};
    }

    @Override
    public Object[] runDelete() {
        this.query = "DELETE FROM CoachRel WHERE coach_id = ?;";
        return new Object[] {coachId};
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
