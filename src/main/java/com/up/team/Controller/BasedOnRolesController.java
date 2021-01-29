package com.up.team.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasedOnRolesController {

    @GetMapping("/guests")
    public String showLeaders() {

        return "guests";
    }

    @GetMapping("/systems")
    public String showSystems() {

        return "systems";
    }
}
