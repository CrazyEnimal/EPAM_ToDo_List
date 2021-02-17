package org.etd.up.controllers;

import org.etd.up.helpers.HelperServices;
import org.etd.up.models.Member;
import org.etd.up.repo.MemberRepository;
import org.etd.up.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private RoleRepository roleRepository;


    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addNewMember(@RequestParam(name = "username") String username,
                               @RequestParam(name = "password") String password,
                               @RequestParam(name = "email") String email,
                               Map<String,Object> model) {
        Member member = memberRepository.findMemberByUserName(username);
        if(member != null){
            model.put("message", "User exists!");
            return "registration";
        }

        member = new Member();
        member.setUserName(username);
        member.setFirstName(username);
        member.setPassword(HelperServices.passwordEncoder().encode(password));
        member.setEmail(email);
        member.setRole(this.roleRepository.findRoleByTitle("USER"));
        member.setActive(true);
        this.memberRepository.save(member);

        return "redirect:/login";
    }
}
