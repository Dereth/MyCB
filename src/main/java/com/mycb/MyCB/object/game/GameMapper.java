package com.mycb.MyCB.object.game;

import com.mycb.MyCB.object.player.Player;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GameMapper implements RowMapper<Game> {
    public static final GameMapper INSTANCE;

    public Game mapRow(ResultSet set, int rowNum) throws SQLException {
        return Game.fromMap(set);
    }

    static {
        INSTANCE = new GameMapper();
    }
}
