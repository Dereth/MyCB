package com.mycb.MyCB.webpage.modify;

import com.mycb.MyCB.object.modification.ModifyTeamForm;
import com.mycb.MyCB.webpage.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ModifyTeamController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/modify/team")
    public String modifyTeam(ModifyTeamForm modifyTeamForm) {
        return Util.MODIFY_TEAM;
    }

    @PostMapping("/modify/team")
    public String postModifyTeam(ModifyTeamForm modifyTeamForm, BindingResult bindingResult) {
        modifyTeamForm.run(jdbcTemplate);
        return "redirect:/modify/team";
    }

}
