package org.etd.up.rest;

import org.etd.up.models.*;
import org.etd.up.repo.MemberRepository;
import org.etd.up.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/project")
public class ProjectRestController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/{id}")
    Project project(@PathVariable int id) {
        return this.projectRepository.findById(id);
    }

    @GetMapping
    Collection<Project> getProjects() {
        return this.projectRepository.findAll();
    }

    @PostMapping
    String addNewProject(
            @RequestParam int creator_id,
            @RequestParam String title
    ){
        Member creator = this.memberRepository.findById(creator_id);
        Project project = new Project(creator, title);

        this.projectRepository.save(project);
        return "{\"success\":true}";
    }
}
