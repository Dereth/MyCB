package com.mycb.MyCB.webpage.teams;

import com.mycb.MyCB.webpage.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeamsController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/teams")
    public String teams(TeamsScreen teamsScreen, Model model, String type, String search, String order, String limit, String page) {
        teamsScreen.addArgs(type, search, order, limit, page);
        teamsScreen.fillModel(model, jdbcTemplate);
        return Util.TEAMS;
    }

    @PostMapping("/teams")
    public String addResult(TeamsScreen teamsScreen, BindingResult bindingResult) {
        return "redirect:/teams" + teamsScreen.getRedirect();
    }

}
