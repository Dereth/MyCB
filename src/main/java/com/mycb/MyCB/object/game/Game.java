package com.mycb.MyCB.object.game;

import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class Game {
    private String id;
    private String home_team;
    private String away_team;
    private String home_score;
    private String away_score;
    private String date;
    private String winner;
    private String loser;

    public static Game fromMap(ResultSet set) throws SQLException {
        Game game = new Game();
        int id, home_score, away_score;
        String home_team, away_team, date, winner, loser;
        id = set.getInt("game_id");
        home_team = set.getString("home_team");
        away_team = set.getString("away_team");
        home_score = set.getInt("home_score");
        away_score = set.getInt("away_score");
        date = set.getString("date");
        winner = set.getString("winner");
        loser = set.getString("loser");

        game.id = String.valueOf(id);
        game.home_team = home_team == null ? "None" : home_team;
        game.away_team = away_team == null ? "None" : away_team;
        game.home_score = home_score == 0 ? "None" : String.format("%d", home_score);
        game.away_score = away_score == 0 ? "None" : String.format("%d", away_score);
        game.date = date == null ? "None" : date;
        game.winner = winner == null ? "None" : winner;
        game.loser = loser == null ? "None" : loser;

        return game;
    }

    public String getId() {
        return id;
    }

    public String getHome_team() {
        return home_team;
    }

    public String getAway_team() {
        return away_team;
    }

    public String getHome_score() {
        return home_score;
    }

    public String getAway_score() {
        return away_score;
    }

    public String getDate() {
        return date;
    }

    public String getWinner() {
        return winner;
    }

    public String getLoser() {
        return loser;
    }
}
