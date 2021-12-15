package com.mycb.MyCB.webpage.modify;

import com.mycb.MyCB.object.modification.ModifyPlayerForm;
import com.mycb.MyCB.webpage.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ModifyPlayerController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/modify/player")
    public String modifyPlayer(ModifyPlayerForm modifyPlayerForm) {
        return Util.MODIFY_PLAYER;
    }

    @PostMapping("/modify/player")
    public String postModifyPlayer(ModifyPlayerForm modifyPlayerForm, BindingResult bindingResult) {
        modifyPlayerForm.run(jdbcTemplate);
        return "redirect:/modify/player";
    }

}
