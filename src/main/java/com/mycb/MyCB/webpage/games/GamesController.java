package com.mycb.MyCB.webpage.games;

import com.mycb.MyCB.webpage.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GamesController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/games")
    public String games(GamesScreen gamesScreen, Model model, String type, String search, String order, String limit, String page) {
        gamesScreen.addArgs(type, search, order, limit, page);
        gamesScreen.fillModel(model, jdbcTemplate);
        return Util.GAMES;
    }

    @PostMapping("/games")
    public String addResult(GamesScreen gamesScreen, BindingResult bindingResult) {
        return "redirect:/games" + gamesScreen.getRedirect();
    }
}
