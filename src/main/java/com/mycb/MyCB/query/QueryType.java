package com.mycb.MyCB.query;

public enum QueryType {

    PLAYERS_NAME(Queries.playersName, true),
    PLAYERS_WEIGHT(Queries.playersWeight, false),
    PLAYERS_HEIGHT(Queries.playersHeight, false),
    PLAYERS_TEAM(Queries.playersTeam, true),
    PLAYERS_GAME(Queries.playersGame, true);

    private final String query;
    private final boolean hasArg;

    private QueryType(String query, boolean hasArg) {
        this.query = query;
        this.hasArg = hasArg;
    }

    public String getQuery() {
        return query;
    }

    public boolean hasArg() {
        return hasArg;
    }
}
