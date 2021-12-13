package com.mycb.MyCB.object.team;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Team {

    private String id;
    private String name;
    private String wins;
    private String losses;
    private String conference;

    public static Team fromMap(ResultSet set) throws SQLException {

        Team team = new Team();

        int id, wins, losses;
        String name, conference;

        id = set.getInt("team_id");
        wins = set.getInt("wins");
        losses = set.getInt("losses");
        name = set.getString("name");
        conference = set.getString("conference");

        team.id = String.valueOf(id);
        team.wins = String.valueOf(wins);
        team.losses = String.valueOf(losses);
        team.name = name == null ? "None" : name;
        team.conference = conference == null ? "None" : conference;

        return team;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWins() {
        return wins;
    }

    public String getLosses() {
        return losses;
    }

    public String getConference() {
        return conference;
    }
}
