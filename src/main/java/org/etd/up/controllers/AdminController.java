package org.etd.up.controllers;

import org.etd.up.models.Member;
import org.etd.up.repo.MemberRepository;
import org.etd.up.helpers.HelperServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller

public class AdminController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/admin")
//    @PreAuthorize("hasAuthority('admin:read')")
    public String getAdminPage(@AuthenticationPrincipal UserDetails userDetails, Map<String, Object> model){
        if(userDetails == null){
            return "redirect:/error";
        } else {
            if(HelperServices.hasRole(userDetails,"ADMIN"))model.put("isAdmin", true);
            model.put("isLoggedIn", true);
            Member member = memberRepository.findMemberByUserName(userDetails.getUsername());
            if(HelperServices.hasRole(userDetails,"ADMIN")){
                List<Member> members = this.memberRepository.findAll();
                model.put("members", members);

            }
        }
        return "admin";
    }
}
