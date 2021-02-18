package org.etd.up.controllers;

import org.etd.up.models.Task;
import org.etd.up.repo.MemberRepository;
import org.etd.up.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/{id}")
    String getTask(@PathVariable("id") int id, Map<String, Object> model) {
        Task task = taskRepository.findById(id);
        model.put("task", task);
        return "task";
    }
}
