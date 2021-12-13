package com.mycb.MyCB.object.team;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamMapper implements RowMapper<Team> {

    public static final TeamMapper INSTANCE;

    public Team mapRow(ResultSet set, int rowNum) throws SQLException {
        return Team.fromMap(set);
    }

    static {
        INSTANCE = new TeamMapper();
    }
}
