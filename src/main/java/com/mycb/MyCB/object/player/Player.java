package com.mycb.MyCB.object.player;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Player {

    private String playerId;
    private String name;
    private int number;
    private String team;
    private String position;
    private int weight;
    private int height;
    private float ppg;
    private float rpg;
    private float shootingPct;

    public static Player fromMap(ResultSet set) throws SQLException {
        Player player = new Player();
        player.playerId = set.getString("player_id");
        player.name = set.getString("name");
        player.number = set.getInt("number");
        player.team = set.getString("team");
        player.position = set.getString("position");
        player.weight = set.getInt("weight");
        player.height = set.getInt("height");
        player.ppg = set.getFloat("ppg");
        player.rpg = set.getFloat("rpg");
        player.shootingPct = set.getFloat("shooting_pct");
        return player;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public float getPpg() {
        return ppg;
    }

    public float getRpg() {
        return rpg;
    }

    public float getShootingPct() {
        return shootingPct;
    }
}
