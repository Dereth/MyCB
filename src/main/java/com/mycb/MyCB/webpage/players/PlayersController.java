package com.mycb.MyCB.webpage.players;

import com.mycb.MyCB.webpage.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlayersController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/players")
    public String players(PlayersScreen playersScreen, Model model, String type, String search, String order, String limit, String page) {
        playersScreen.addArgs(type, search, order, limit, page);
        playersScreen.fillModel(model, jdbcTemplate);
        return Util.PLAYERS;
    }

    @PostMapping("/players")
    public String addResult(PlayersScreen playersScreen, BindingResult bindingResult) {
        return "redirect:/players" + playersScreen.getRedirect();
    }

}
