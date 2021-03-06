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
    public static final String teamsCoach;

    public static final String gamesHomeTeam;
    public static final String gamesAwayTeam;
    public static final String gamesDate;
    public static final String gamesPlayer;

    public static final String coachesName;
    public static final String coachesTeam;

    static {
        playersName = "" +
                "SELECT p.player_id AS player_id, " +
                "p.name AS name, " +
                "p.number AS number, " +
                "t.name AS team, " +
                "p.position AS position, " +
                "p.weight AS weight, " +
                "p.height AS height, " +
                "p.ppg AS ppg, " +
                "p.rpg AS rpg, " +
                "p.pct AS pct " +
                "FROM Players p LEFT OUTER JOIN PlayerRel r " +
                "ON p.player_id = r.player_id " +
                "LEFT OUTER JOIN Teams t " +
                "ON r.team_id = t.team_id " +
                "WHERE p.name = ? " +
                "ORDER BY p.ppg;";
        playersWeight = "" +
                "SELECT p.player_id AS player_id, " +
                "p.name AS name, " +
                "p.number AS number, " +
                "t.name AS team, " +
                "p.position AS position, " +
                "p.weight AS weight, " +
                "p.height AS height, " +
                "p.ppg AS ppg, " +
                "p.rpg AS rpg, " +
                "p.pct AS pct " +
                "FROM Players p LEFT OUTER JOIN PlayerRel r " +
                "ON p.player_id = r.player_id " +
                "LEFT OUTER JOIN Teams t " +
                "ON r.team_id = t.team_id " +
                "ORDER BY p.weight;";
        playersHeight = "" +
                "SELECT p.player_id AS player_id, " +
                "p.name AS name, " +
                "p.number AS number, " +
                "t.name AS team, " +
                "p.position AS position, " +
                "p.weight AS weight, " +
                "p.height AS height, " +
                "p.ppg AS ppg, " +
                "p.rpg AS rpg, " +
                "p.pct AS pct " +
                "FROM Players p LEFT OUTER JOIN PlayerRel r " +
                "ON p.player_id = r.player_id " +
                "LEFT OUTER JOIN Teams t " +
                "ON r.team_id = t.team_id " +
                "ORDER BY p.height;";
        playersTeam = "" +
                "SELECT p.player_id AS player_id, " +
                "p.name AS name, " +
                "p.number AS number, " +
                "t.name AS team, " +
                "p.position AS position, " +
                "p.weight AS weight, " +
                "p.height AS height, " +
                "p.ppg AS ppg, " +
                "p.rpg AS rpg, " +
                "p.pct AS pct " +
                "FROM Players p LEFT OUTER JOIN PlayerRel r " +
                "ON p.player_id = r.player_id " +
                "LEFT OUTER JOIN Teams t " +
                "ON r.team_id = t.team_id " +
                "WHERE t.name = ? " +
                "ORDER BY p.ppg;";
        playersGame = "" +
                "SELECT p.player_id AS player_id, " +
                "p.name AS name, " +
                "p.number AS number, " +
                "t.name AS team, " +
                "p.position AS position, " +
                "p.weight AS weight, " +
                "p.height AS height, " +
                "p.ppg AS ppg, " +
                "p.rpg AS rpg, " +
                "p.pct AS pct " +
                "FROM Players p LEFT OUTER JOIN PlayerRel r " +
                "ON p.player_id = r.player_id " +
                "LEFT OUTER JOIN Teams t " +
                "ON r.team_id = t.team_id " +
                "JOIN Games g " +
                "ON t.team_id = g.home_team_id " +
                "OR t.team_id = g.away_team_id " +
                "WHERE g.game_id = ? " +
                "ORDER BY p.ppg;";

        teamsName = "" +
                "SELECT t.team_id AS team_id, " +
                "t.name AS name, " +
                "t.wins AS wins, " +
                "t.losses AS losses, " +
                "t.conference AS conference " +
                "FROM Teams t " +
                "WHERE t.name = ? " +
                "ORDER BY t.name;";
        teamsWins = "" +
                "SELECT t.team_id AS team_id, " +
                "t.name AS name, " +
                "t.wins AS wins, " +
                "t.losses AS losses, " +
                "t.conference AS conference " +
                "FROM Teams t " +
                "WHERE t.wins = ? " +
                "ORDER BY t.wins;";
        teamsLosses = "" +
                "SELECT t.team_id AS team_id, " +
                "t.name AS name, " +
                "t.wins AS wins, " +
                "t.losses AS losses, " +
                "t.conference AS conference " +
                "FROM Teams t " +
                "WHERE t.losses = ? " +
                "ORDER BY t.losses;";
        teamsConference = "" +
                "SELECT t.team_id AS team_id, " +
                "t.name AS name, " +
                "t.wins AS wins, " +
                "t.losses AS losses, " +
                "t.conference AS conference " +
                "FROM Teams t " +
                "WHERE t.conference = ? " +
                "ORDER BY t.conference;";
        teamsCoach = "" +
                "SELECT t.team_id AS team_id, " +
                "t.name AS name, " +
                "t.wins AS wins, " +
                "t.losses AS losses, " +
                "t.conference AS conference " +
                "FROM Teams t LEFT OUTER JOIN CoachRel " +
                "ON t.team_id = CoachRel.team_id " +
                "WHERE CoachRel.coach_id = ? " +
                "ORDER BY t.conference;";

        gamesHomeTeam = "" +
                "SELECT g.game_id AS game_id, " +
                "g.date AS date, " +
                "ht.name AS home_team, " +
                "at.name AS away_team, " +
                "g.home_score AS home_score, " +
                "g.away_score AS away_score, " +
                "w.name AS winner, " +
                "l.name AS loser " +
                "FROM Games g " +
                "LEFT OUTER JOIN Teams ht " +
                "ON g.home_team_id = ht.team_id " +
                "LEFT OUTER JOIN Teams at " +
                "ON g.away_team_id = at.team_id " +
                "LEFT OUTER JOIN Teams w " +
                "ON g.winner_id = w.team_id " +
                "LEFT OUTER JOIN Teams l " +
                "ON g.loser_id = l.team_id " +
                "WHERE ht.name = ?;";
        gamesAwayTeam = "" +
                "SELECT g.game_id AS game_id, " +
                "g.date AS date, " +
                "ht.name AS home_team, " +
                "at.name AS away_team, " +
                "g.home_score AS home_score, " +
                "g.away_score AS away_score, " +
                "w.name AS winner, " +
                "l.name AS loser " +
                "FROM Games g " +
                "LEFT OUTER JOIN Teams ht " +
                "ON g.home_team_id = ht.team_id " +
                "LEFT OUTER JOIN Teams at " +
                "ON g.away_team_id = at.team_id " +
                "LEFT OUTER JOIN Teams w " +
                "ON g.winner_id = w.team_id " +
                "LEFT OUTER JOIN Teams l " +
                "ON g.loser_id = l.team_id " +
                "WHERE at.name = ?;";
        gamesDate = "" +
                "SELECT g.game_id AS game_id, " +
                "g.date AS date, " +
                "ht.name AS home_team, " +
                "at.name AS away_team, " +
                "g.home_score AS home_score, " +
                "g.away_score AS away_score, " +
                "w.name AS winner, " +
                "l.name AS loser " +
                "FROM Games g " +
                "LEFT OUTER JOIN Teams ht " +
                "ON g.home_team_id = ht.team_id " +
                "LEFT OUTER JOIN Teams at " +
                "ON g.away_team_id = at.team_id " +
                "LEFT OUTER JOIN Teams w " +
                "ON g.winner_id = w.team_id " +
                "LEFT OUTER JOIN Teams l " +
                "ON g.loser_id = l.team_id " +
                "WHERE g.date = ?;";
        gamesPlayer = "" +
                "SELECT g.game_id AS game_id, " +
                "g.date AS date, " +
                "ht.name AS home_team, " +
                "at.name AS away_team, " +
                "g.home_score AS home_score, " +
                "g.away_score AS away_score, " +
                "w.name AS winner, " +
                "l.name AS loser " +
                "FROM Games g " +
                "LEFT OUTER JOIN Teams ht " +
                "ON g.home_team_id = ht.team_id " +
                "LEFT OUTER JOIN Teams at " +
                "ON g.away_team_id = at.team_id " +
                "LEFT OUTER JOIN Teams w " +
                "ON g.winner_id = w.team_id " +
                "LEFT OUTER JOIN Teams l " +
                "ON g.loser_id = l.team_id " +
                "LEFT OUTER JOIN PlayerRel " +
                "ON g.home_team_id = PlayerRel.team_id " +
                "OR g.away_team_id = PlayerRel.team_id " +
                "WHERE PlayerRel.player_id = ?;";

        coachesName = "" +
                "SELECT c.coach_id AS coach_id, " +
                "c.name AS name, " +
                "t.name AS team_name " +
                "FROM Coaches c " +
                "LEFT OUTER JOIN CoachRel " +
                "ON c.coach_id = CoachRel.coach_id " +
                "LEFT OUTER JOIN Teams t " +
                "ON CoachRel.team_id = t.team_id " +
                "WHERE c.name = ? " +
                "ORDER BY t.wins;";
        coachesTeam = "" +
                "SELECT c.coach_id AS coach_id, " +
                "c.name AS name, " +
                "t.name AS team_name " +
                "FROM Coaches c " +
                "LEFT OUTER JOIN CoachRel " +
                "ON c.coach_id = CoachRel.coach_id " +
                "LEFT OUTER JOIN Teams t " +
                "ON CoachRel.team_id = t.team_id " +
                "WHERE t.name = ? " +
                "ORDER BY t.wins;";
    }
}
