package com.mycb.MyCB.coach;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoachMapper implements RowMapper<Coach> {
    public Coach mapRow(ResultSet set, int rowNum) throws SQLException {
        return Coach.fromMap(set);
    }
}
