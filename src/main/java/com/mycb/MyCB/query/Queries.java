package com.mycb.MyCB.query;

public class Queries {

    public static final String testQuery;
    public static final String playersName;

    static {
        testQuery = "test";
        playersName = "" +
                "SELECT name, number, team, position, weight, height, ppg, rpg, pct " +
                "FROM Players " +
                "WHERE name = ? " +
                "ORDER BY ppg;";
    }
}
