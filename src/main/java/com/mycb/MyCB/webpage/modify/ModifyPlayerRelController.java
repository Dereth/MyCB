package com.mycb.MyCB.webpage.modify;

import com.mycb.MyCB.object.modification.ModifyPlayerRelForm;
import com.mycb.MyCB.webpage.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ModifyPlayerRelController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/modify/playerrel")
    public String modifyPlayerRel(ModifyPlayerRelForm modifyPlayerRelForm) {
        return Util.MODIFY_PLAYER_REL;
    }

    @PostMapping("/modify/playerrel")
    public String postModifyPlayerRel(ModifyPlayerRelForm modifyPlayerRelForm, BindingResult bindingResult) {
        modifyPlayerRelForm.run(jdbcTemplate);
        return "redirect:/modify/playerrel";
    }

}
