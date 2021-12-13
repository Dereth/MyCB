package com.mycb.MyCB.webpage.modify;

import com.mycb.MyCB.object.modification.ModifyCoachForm;
import com.mycb.MyCB.webpage.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ModifyCoachController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/modify/coach")
    public String modifyCoach(ModifyCoachForm modifyCoachForm) {
        return Util.MODIFY_COACH;
    }

    @PostMapping("/modify/coach")
    public String postModifyCoach(ModifyCoachForm modifyCoachForm, BindingResult bindingResult) {
        modifyCoachForm.run(jdbcTemplate);
        return "redirect:/modify/coach";
    }

}
