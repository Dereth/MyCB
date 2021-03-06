package com.mycb.MyCB.object.player;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerMapper implements RowMapper<Player> {
    public Player mapRow(ResultSet set, int rowNum) throws SQLException {
        return Player.fromMap(set);
    }
}
