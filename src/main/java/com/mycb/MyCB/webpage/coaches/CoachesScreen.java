package com.mycb.MyCB.webpage.coaches;

import com.mycb.MyCB.coach.CoachMapper;
import com.mycb.MyCB.object.team.TeamMapper;
import com.mycb.MyCB.query.QueryScreen;
import com.mycb.MyCB.query.QueryType;
import org.springframework.jdbc.core.RowMapper;

public class CoachesScreen extends QueryScreen {

    public QueryType parseType(String type) {
        switch (type) {
            case "name": {
                return QueryType.COACH_NAME;
            }
            case "team": {
                return QueryType.COACH_TEAM;
            }
        }
        return null;
    }

    public RowMapper<?> getMapper() {
        return new CoachMapper();
    }
}
