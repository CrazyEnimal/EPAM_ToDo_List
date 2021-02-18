package org.etd.up.rest;

import org.etd.up.models.Member;
import org.etd.up.models.Message;
import org.etd.up.models.Task;
import org.etd.up.models.TaskFollower;
import org.etd.up.repo.MemberRepository;
import org.etd.up.repo.StatusRepository;
import org.etd.up.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Collection;
import java.util.List;

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
    List<Member> getTaskFollowers(@PathVariable int id){
        Task task = this.taskRepository.findById(id);
        return task.getTaskFollowers();
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

    @PutMapping("/{id}")
    String complete(@PathVariable("id") int id) {
        Task task = this.taskRepository.findById(id);
        task.setComplete(true);
        this.taskRepository.save(task);
        return "{\"success\":true}";
    }

    @PutMapping("/{id}/follower/{member_id}")
    String addFollover(@PathVariable("id") int id, int member_id) {
        Task task = this.taskRepository.findById(id);
        task.addFollower(this.memberRepository.findById(member_id));
        this.taskRepository.save(task);
        return "{\"success\":true}";
    }

    @PutMapping("/{id}")
    String addMessage(@PathVariable("id") int id, Message message) {
        Task task = this.taskRepository.findById(id);
        task.addMessage(message);
        this.taskRepository.save(task);
        return "{\"success\":true}";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        this.taskRepository.deleteById(id);
        return "{\"success\":true}";
    }

}
