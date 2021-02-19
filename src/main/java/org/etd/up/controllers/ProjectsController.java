package org.etd.up.controllers;

import org.etd.up.helpers.HelperServices;
import org.etd.up.models.Member;
import org.etd.up.models.Project;
import org.etd.up.models.Task;
import org.etd.up.models.Team;
import org.etd.up.repo.MemberRepository;
import org.etd.up.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping()
public class ProjectsController {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/projects")
    public String getProjects(@AuthenticationPrincipal UserDetails userDetails,
                              Map<String, Object> model){
        if(userDetails == null){
            model.put("isLoggedIn", false);
        } else {
            if(HelperServices.hasRole(userDetails,"ADMIN"))model.put("isAdmin", true);
            model.put("isLoggedIn", true);

            Member member = memberRepository.findMemberByUserName(userDetails.getUsername());
            List<Project> projects;

            if(HelperServices.hasRole(userDetails,"ADMIN")){
                projects = projectRepository.findAll();
            }
            else {
                projects = projectRepository.findProjectByProjectFollowers(member);
            }

            model.put("projects", projects);
        }


        return "projects";
    }

    @GetMapping("/projects/{id}")
    public String getProject(@PathVariable int id, Map<String, Object> model) {
        Project project = projectRepository.findById(id);
        List<Task> tasks = project.getTasks();
        List<Member> followers = project.getFollowers();
        model.put("project", project);
        model.put("tasks", tasks);
        model.put("followers", followers);

        return "project";

    }




}
