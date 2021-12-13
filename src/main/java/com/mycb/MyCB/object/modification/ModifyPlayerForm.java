package com.mycb.MyCB.object.modification;

import org.springframework.jdbc.core.JdbcTemplate;

public class ModifyPlayerForm extends ModifyForm {

    private String playerId;
    private String name;
    private String number;
    private String position;
    private String weight;
    private String height;
    private String ppg;
    private String rpg;
    private String pct;

    @Override
    public Object[] runInsert() {
        this.query = "INSERT INTO Players VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
        return new Object[] {playerId, name, number, position, weight, height, ppg, rpg, pct};
    }

    @Override
    public Object[] runUpdate() {
        this.query = "UPDATE Players SET name = ?, number = ?, position = ?, weight = ?, height = ?, ppg = ?, rpg = ?, pct = ? WHERE player_id = ?";
        return new Object[] {name, number, position, weight, height, ppg, rpg, pct, playerId};
    }

    @Override
    public Object[] runDelete() {
        this.query = "DELETE FROM Players WHERE player_id = ?;";
        return new Object[] {playerId};
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPpg() {
        return ppg;
    }

    public void setPpg(String ppg) {
        this.ppg = ppg;
    }

    public String getRpg() {
        return rpg;
    }

    public void setRpg(String rpg) {
        this.rpg = rpg;
    }

    public String getPct() {
        return pct;
    }

    public void setPct(String pct) {
        this.pct = pct;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}
