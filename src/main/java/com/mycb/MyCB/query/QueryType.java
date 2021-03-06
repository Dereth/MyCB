package com.mycb.MyCB.query;

public enum QueryType {

    PLAYERS_NAME(Queries.playersName, true),
    PLAYERS_WEIGHT(Queries.playersWeight, false),
    PLAYERS_HEIGHT(Queries.playersHeight, false),
    PLAYERS_TEAM(Queries.playersTeam, true),
    PLAYERS_GAME(Queries.playersGame, true),
    TEAMS_NAME(Queries.teamsName, true),
    TEAMS_WINS(Queries.teamsWins, true),
    TEAMS_LOSSES(Queries.teamsLosses, true),
    TEAMS_CONFERENCE(Queries.teamsConference, true),
    TEAMS_COACH(Queries.teamsCoach, true),
    GAMES_HOME_TEAM(Queries.gamesHomeTeam, true),
    GAMES_AWAY_TEAM(Queries.gamesAwayTeam, true),
    GAMES_DATE(Queries.gamesDate, true),
    GAMES_PLAYER(Queries.gamesPlayer, true),
    COACH_NAME(Queries.coachesName, true),
    COACH_TEAM(Queries.coachesTeam, true);

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
