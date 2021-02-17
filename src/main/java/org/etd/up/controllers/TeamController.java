package org.etd.up.controllers;

import org.etd.up.models.Member;
import org.etd.up.models.Project;
import org.etd.up.models.Team;
import org.etd.up.models.TeamProject;
import org.etd.up.repo.MemberRepository;
import org.etd.up.repo.ProjectRepository;
import org.etd.up.repo.TeamRepository;
import org.etd.up.helpers.HelperServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping()
public class TeamController {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/teams")
    public String getTeams(@AuthenticationPrincipal UserDetails userDetails,
                           Map<String, Object> model){
        if(userDetails == null){
            model.put("isLoggedIn", false);
        } else {
            if(HelperServices.hasRole(userDetails,"ADMIN"))model.put("isAdmin", true);
            model.put("isLoggedIn", true);

            Member member = memberRepository.findMemberByUserName(userDetails.getUsername());
            List<Team> teams;

            if(HelperServices.hasRole(userDetails,"ADMIN")){
                teams = teamRepository.findAll();
            } else {
                teams = teamRepository.findTeamsByTeamFollowers(member);
            }

            model.put("teams", teams);
        }


        return "teams";
    }

    @GetMapping("/teams/{id}")
    public String getTeamById(@AuthenticationPrincipal UserDetails userDetails,
                              @PathVariable int id,
                              Map<String, Object> model) {
        if (userDetails == null) {
            model.put("isLoggedIn", false);
        } else {
            if (HelperServices.hasRole(userDetails, "ADMIN")) model.put("isAdmin", true);
            model.put("isLoggedIn", true);

            Member member = memberRepository.findMemberByUserName(userDetails.getUsername());
            Team team = teamRepository.findById(id);
            List<Project> projects = team.getTeamProjects();
            if (team == null || projects.isEmpty()){
                return "error";
            }

            model.put("projects", projects);
        }

        return "teams";
    }
}
