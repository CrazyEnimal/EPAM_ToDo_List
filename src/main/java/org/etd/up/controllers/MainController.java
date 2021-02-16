package org.etd.up.controllers;

import org.etd.up.services.HelperServices;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping
    public String home(@AuthenticationPrincipal UserDetails userDetails, Map<String, Object> model) {
        if(userDetails == null){
            model.put("isLoggedIn", false);
        } else {
            if(HelperServices.hasRole(userDetails,"ADMIN"))model.put("isAdmin", true);
            model.put("isLoggedIn", true);
        }
        return "home";
    }

    @GetMapping("/main")
    public String main(@AuthenticationPrincipal UserDetails userDetails, Map<String, Object> model) {
        if(userDetails == null){
            model.put("isLoggedIn", false);
        } else {
            if(HelperServices.hasRole(userDetails,"ADMIN"))model.put("isAdmin", true);
            model.put("isLoggedIn", true);
        }
        return "main";
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }
}
