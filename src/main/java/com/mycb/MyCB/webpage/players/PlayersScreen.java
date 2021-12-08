package com.mycb.MyCB.webpage.players;

import com.mycb.MyCB.query.QueryType;
import com.mycb.MyCB.query.QueryScreen;

public class PlayersScreen extends QueryScreen {

    public QueryType parseType(String type) {
        switch (type) {
            case "name": {
                return QueryType.PLAYERS_NAME;
            }
        }
        return null;
    }
}
