package org.etd.up.rest;

import org.etd.up.models.Member;
import org.etd.up.models.Task;
import org.etd.up.models.TaskFollower;
import org.etd.up.repo.MemberRepository;
import org.etd.up.repo.StatusRepository;
import org.etd.up.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/task")
public class TaskRestController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    StatusRepository statusRepository;

    @GetMapping("/{id}")
    Task getTask(@PathVariable int id){
        Task task = this.taskRepository.findById(id);
        return task;
    }

    @GetMapping("/{id}/followers")
    Collection<TaskFollower> getTaskFollowers(@PathVariable int id){
        Task task = this.taskRepository.findById(id);
        Collection<TaskFollower> followers = this.taskRepository.findAllByTaskFollowers(id);
        return followers;
    }

    @PostMapping
    String addNewTask(
            @RequestParam int creator_id,
            @RequestParam String title
    ){
        Member creator = this.memberRepository.findById(creator_id);
        Task task = new Task(creator, title);
        task.setStatus(this.statusRepository.findById(1));
        task.setComplete(false);
        this.taskRepository.save(task);
        return "{\"success\":true}";
    }
}
