package com.mycb.MyCB.webpage.coaches;

import com.mycb.MyCB.webpage.Util;
import com.mycb.MyCB.webpage.games.GamesScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CoachesController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/coaches")
    public String coaches(CoachesScreen coachesScreen, Model model, String type, String search, String order, String limit, String page) {
        coachesScreen.addArgs(type, search, order, limit, page);
        coachesScreen.fillModel(model, jdbcTemplate);
        return Util.COACHES;
    }

    @PostMapping("/coaches")
    public String addResult(CoachesScreen coachesScreen, BindingResult bindingResult) {
        return "redirect:/coaches" + coachesScreen.getRedirect();
    }
}
