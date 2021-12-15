package com.mycb.MyCB.webpage.players;

import com.mycb.MyCB.object.player.PlayerMapper;
import com.mycb.MyCB.query.QueryType;
import com.mycb.MyCB.query.QueryScreen;
import org.springframework.jdbc.core.RowMapper;

public class PlayersScreen extends QueryScreen {

    public QueryType parseType(String type) {
        switch (type) {
            case "name": {
                return QueryType.PLAYERS_NAME;
            }
            case "team": {
                return QueryType.PLAYERS_TEAM;
            }
            case "weight": {
                return QueryType.PLAYERS_WEIGHT;
            }
            case "height": {
                return QueryType.PLAYERS_HEIGHT;
            }
            case "game": {
                return QueryType.PLAYERS_GAME;
            }
        }
        return null;
    }

    public RowMapper<?> getMapper() {
        return new PlayerMapper();
    }
}
