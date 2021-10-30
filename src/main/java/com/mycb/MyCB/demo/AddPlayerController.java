package com.mycb.MyCB.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddPlayerController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/add")
    public String addForm(PlayerForm playerForm) {
        return "add";
    }

    @PostMapping("/add")
    public String addResult(PlayerForm playerForm, BindingResult bindingResult) {

        jdbcTemplate.execute("INSERT INTO players VALUES ('" + playerForm.getName() + "');");

        return "redirect:/get";
    }
}
