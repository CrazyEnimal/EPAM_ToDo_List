package org.etd.up.controllers;

import org.etd.up.models.Project;
import org.etd.up.models.Task;
import org.etd.up.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/project")
public class ProjectsController {
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/{id}")
    public String getProject(@PathVariable int id, Map<String, Object> model) {
        Project project = projectRepository.findById(id);
        List<Task> tasks = project.getTasks();
        model.put("project", project);
        model.put("tasks", tasks);

        return "project";

    }


}
