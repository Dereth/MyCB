package com.mycb.MyCB.object.modification;

public class ModifyPlayerRelForm extends ModifyForm {

    private String playerId;
    private String teamId;

    @Override
    public Object[] runInsert() {
        this.query = "INSERT INTO PlayerRel VALUES(?, ?);";
        return new Object[] {playerId, teamId};
    }

    @Override
    public Object[] runUpdate() {
        this.query = "UPDATE PlayerRel SET team_id = ? WHERE player_id = ?";
        return new Object[] {teamId, playerId};
    }

    @Override
    public Object[] runDelete() {
        this.query = "DELETE FROM PlayerRel WHERE player_id = ?;";
        return new Object[] {playerId};
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
