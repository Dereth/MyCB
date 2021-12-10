package com.mycb.MyCB.object.player;

import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class Player {

    private String id;
    private String name;
    private String number;
    private String team;
    private String position;
    private String weight;
    private String height;
    private String ppg;
    private String rpg;
    private String pct;

    public static Player fromMap(ResultSet set) throws SQLException {
        Player player = new Player();
        int id;
        String name, number, team, position;
        float weight, height, ppg, rpg, pct;

        id = set.getInt("player_id");
        name = set.getString("name");
        number = set.getString("number");
        team = set.getString("team");
        position = set.getString("position");
        weight = set.getFloat("weight");
        height = set.getFloat("height");
        ppg = set.getFloat("ppg");
        rpg = set.getFloat("rpg");
        pct = set.getFloat("pct");

        player.id = String.valueOf(id);
        player.name = name == null ? "None" : name;
        player.number = number == null ? "None" : number;
        player.team = team == null ? "None" : team;
        player.position = position == null ? "None" : position;
        player.weight = weight == 0 ? "None" : String.format("%.3f", weight);
        player.height = height == 0 ? "None" : String.format("%.3f", height);
        player.ppg = ppg == 0 ? "None" : String.format("%.3f", ppg);
        player.rpg = rpg == 0 ? "None" : String.format("%.3f", rpg);
        player.pct = pct == 0 ? "None" : String.format("%.3f", pct);

        return player;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }

    public String getPpg() {
        return ppg;
    }

    public String getRpg() {
        return rpg;
    }

    public String getPct() {
        return pct;
    }
}
