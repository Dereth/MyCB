package com.mycb.MyCB.webpage.modify;

import com.mycb.MyCB.object.modification.ModifyCoachRelForm;
import com.mycb.MyCB.webpage.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ModifyCoachRelController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/modify/coachrel")
    public String modifyCoachRel(ModifyCoachRelForm modifyCoachRelForm) {
        return Util.MODIFY_COACH_REL;
    }

    @PostMapping("/modify/coachrel")
    public String postModifyPlayerRel(ModifyCoachRelForm modifyCoachRelForm, BindingResult bindingResult) {
        modifyCoachRelForm.run(jdbcTemplate);
        return "redirect:/modify/coachrel";
    }

}
