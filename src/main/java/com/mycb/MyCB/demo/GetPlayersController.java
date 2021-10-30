package com.mycb.MyCB.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
public class GetPlayersController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/get")
    public String get(Model model) {
        model.addAttribute("players", jdbcTemplate.query("select * from players;", new PlayerMapper()));
        return "get";
    }
}
