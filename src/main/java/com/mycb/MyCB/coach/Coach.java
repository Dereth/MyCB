package com.mycb.MyCB.coach;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Coach {

    private String id;
    private String name;
    private String team;


    public static Coach fromMap(ResultSet set) throws SQLException {
        Coach coach = new Coach();
        int id;
        String name, team;

        id = set.getInt("coach_id");
        name = set.getString("name");
        team = set.getString("team_name");

        coach.id = String.valueOf(id);
        coach.name = name == null ? "None" : name;
        coach.team = team == null ? "None" : team;

        return coach;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }
}
