package com.mycb.MyCB.webpage.games;

import com.mycb.MyCB.demo.PlayerMapper;
import com.mycb.MyCB.object.game.GameMapper;
import com.mycb.MyCB.query.QueryType;
import com.mycb.MyCB.query.QueryScreen;
import org.springframework.jdbc.core.RowMapper;
public class GamesScreen extends QueryScreen{
    public QueryType parseType(String type) {
        switch(type) {
            case "home_team": {
                return QueryType.GAMES_HOME_TEAM;
            }
            case "away_team": {
                return QueryType.GAMES_AWAY_TEAM;
            }
            case "date": {
                return QueryType.GAMES_DATE;
            }
        }
        return null;
    }

    public RowMapper<?> getMapper() {return new GameMapper();}
}
