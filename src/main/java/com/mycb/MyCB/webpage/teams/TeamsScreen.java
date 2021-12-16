package com.mycb.MyCB.webpage.teams;

import com.mycb.MyCB.object.team.TeamMapper;
import com.mycb.MyCB.query.QueryScreen;
import com.mycb.MyCB.query.QueryType;
import org.springframework.jdbc.core.RowMapper;

public class TeamsScreen extends QueryScreen {

    public QueryType parseType(String type) {
        switch (type) {
            case "name": {
                return QueryType.TEAMS_NAME;
            }
            case "wins": {
                return QueryType.TEAMS_WINS;
            }
            case "losses": {
                return QueryType.TEAMS_LOSSES;
            }
            case "conference": {
                return QueryType.TEAMS_CONFERENCE;
            }
            case "coach": {
                return QueryType.TEAMS_COACH;
            }
        }
        return null;
    }

    public RowMapper<?> getMapper() {
        return new TeamMapper();
    }
}
