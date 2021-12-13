package com.mycb.MyCB.webpage.modify;

import com.mycb.MyCB.webpage.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModifyController {

    @GetMapping("/modify")
    public String welcome() {
        return Util.MODIFY;
    }
}
