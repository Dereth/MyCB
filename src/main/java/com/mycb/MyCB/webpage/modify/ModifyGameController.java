package com.mycb.MyCB.webpage.modify;

import com.mycb.MyCB.object.modification.ModifyGameForm;
import com.mycb.MyCB.webpage.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ModifyGameController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/modify/game")
    public String modifyGame(ModifyGameForm modifyGameForm) {
        return Util.MODIFY_GAME;
    }

    @PostMapping("/modify/game")
    public String postModifyGame(ModifyGameForm modifyGameForm, BindingResult bindingResult) {
        modifyGameForm.run(jdbcTemplate);
        return "redirect:/modify/game";
    }

}
