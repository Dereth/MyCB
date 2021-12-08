package com.mycb.MyCB.query;


import com.mycb.MyCB.object.player.PlayerMapper;
import org.springframework.jdbc.core.RowMapper;

public enum QueryType {

    PLAYERS_NAME(Queries.playersName, PlayerMapper.INSTANCE, true);

    private final String query;
    private final RowMapper<?> mapper;
    private final boolean hasArg;

    private QueryType(String query, RowMapper<?> mapper, boolean hasArg) {
        this.query = query;
        this.mapper = mapper;
        this.hasArg = hasArg;
    }

    public String getQuery() {
        return query;
    }

    public RowMapper<?> getMapper() {
        return mapper;
    }

    public boolean hasArg() {
        return hasArg;
    }
}
