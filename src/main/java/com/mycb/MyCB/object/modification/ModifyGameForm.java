package com.mycb.MyCB.object.modification;

public class ModifyGameForm extends ModifyForm {

    private String gameId;
    private String homeTeamId;
    private String awayTeamId;
    private String homeScore;
    private String awayScore;
    private String date;
    private String winnerId;

    @Override
    public Object[] runInsert() {
        this.query = "INSERT INTO Games VALUES(?, ?, ?, ?, ?, ?, ?);";
        return new Object[] {gameId, homeTeamId, awayTeamId, homeScore, awayScore, date, winnerId};
    }

    @Override
    public Object[] runUpdate() {
        this.query = "UPDATE Games SET home_team_id = ?, away_team_id = ?, home_score = ?, away_score = ?, date = ?, winner_id = ?, WHERE game_id = ?";
        return new Object[] {homeTeamId, awayTeamId, homeScore, awayScore, date, winnerId, gameId};
    }

    @Override
    public Object[] runDelete() {
        this.query = "DELETE FROM Games WHERE game_id = ?;";
        return new Object[] {gameId};
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(String homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(String awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore;
    }

    public String getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(String awayScore) {
        this.awayScore = awayScore;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(String winnerId) {
        this.winnerId = winnerId;
    }
}
