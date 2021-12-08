package com.mycb.MyCB.webpage.welcome;

import com.mycb.MyCB.webpage.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return Util.WELCOME;
    }

}
