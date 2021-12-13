package com.mycb.MyCB.query;

public class Queries {

    public static final String playersName;
    public static final String playersWeight;
    public static final String playersHeight;
    public static final String playersTeam;
    public static final String playersGame;

    public static final String teamsName;
    public static final String teamsWins;
    public static final String teamsLosses;
    public static final String teamsConference;

    static {
        playersName = "" +
                "SELECT p.name AS name, " +
                "p.number AS number, " +
                "t.name AS team, " +
                "p.position AS position, " +
                "p.weight AS weight, " +
                "p.height AS height, " +
                "p.ppg AS ppg, " +
                "p.rpg AS rpg, " +
                "p.pct AS pct " +
                "FROM Players p JOIN PlayerRel r " +
                "ON p.player_id = r.player_id " +
                "JOIN Teams t " +
                "ON r.team_id = t.team_id " +
                "WHERE p.name = ? " +
                "ORDER BY p.ppg;";
        playersWeight = "" +
                "SELECT p.name AS name, " +
                "p.number AS number, " +
                "t.name AS team, " +
                "p.position AS position, " +
                "p.weight AS weight, " +
                "p.height AS height, " +
                "p.ppg AS ppg, " +
                "p.rpg AS rpg, " +
                "p.pct AS pct " +
                "FROM Players p JOIN PlayerRel r " +
                "ON p.player_id = r.player_id " +
                "JOIN Teams t " +
                "ON r.team_id = t.team_id " +
                "ORDER BY p.weight;";
        playersHeight = "" +
                "SELECT p.name AS name, " +
                "p.number AS number, " +
                "t.name AS team, " +
                "p.position AS position, " +
                "p.weight AS weight, " +
                "p.height AS height, " +
                "p.ppg AS ppg, " +
                "p.rpg AS rpg, " +
                "p.pct AS pct " +
                "FROM Players p JOIN PlayerRel r " +
                "ON p.player_id = r.player_id " +
                "JOIN Teams t " +
                "ON r.team_id = t.team_id " +
                "ORDER BY p.height;";
        playersTeam = "" +
                "SELECT p.name AS name, " +
                "p.number AS number, " +
                "t.name AS team, " +
                "p.position AS position, " +
                "p.weight AS weight, " +
                "p.height AS height, " +
                "p.ppg AS ppg, " +
                "p.rpg AS rpg, " +
                "p.pct AS pct " +
                "FROM Players p JOIN PlayerRel r " +
                "ON p.player_id = r.player_id " +
                "JOIN Teams t " +
                "ON r.team_id = t.team_id " +
                "WHERE t.name = ? " +
                "ORDER BY p.ppg;";
        playersGame = "" +
                "SELECT p.name AS name, " +
                "p.number AS number, " +
                "t.name AS team, " +
                "p.position AS position, " +
                "p.weight AS weight, " +
                "p.height AS height, " +
                "p.ppg AS ppg, " +
                "p.rpg AS rpg, " +
                "p.pct AS pct " +
                "FROM Players p JOIN PlayerRel r " +
                "ON p.player_id = r.player_id " +
                "JOIN Teams t " +
                "ON r.team_id = t.team_id " +
                "JOIN Games g " +
                "ON t.team_id = g.home_team_id " +
                "OR t.team_id = g.away_team_id " +
                "WHERE g.game_id = ? " +
                "ORDER BY p.ppg;";

        teamsName = "" +
                "SELECT t.name AS name, " +
                "t.wins AS wins, " +
                "t.losses AS losses, " +
                "t.conference AS conference " +
                "FROM Teams t " +
                "WHERE t.name = ? " +
                "ORDER BY t.name;";
        teamsWins = "" +
                "SELECT t.name AS name, " +
                "t.wins AS wins, " +
                "t.losses AS losses, " +
                "t.conference AS conference " +
                "FROM Teams t " +
                "WHERE t.wins = ? " +
                "ORDER BY t.wins;";
        teamsLosses = "" +
                "SELECT t.name AS name, " +
                "t.wins AS wins, " +
                "t.losses AS losses, " +
                "t.conference AS conference " +
                "FROM Teams t " +
                "WHERE t.losses = ? " +
                "ORDER BY t.losses;";
        teamsConference = "" +
                "SELECT t.name AS name, " +
                "t.wins AS wins, " +
                "t.losses AS losses, " +
                "t.conference AS conference " +
                "FROM Teams t " +
                "WHERE t.conference = ? " +
                "ORDER BY t.conference;";
    }
}
