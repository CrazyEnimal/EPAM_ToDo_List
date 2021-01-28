package services;

import dao.MemberDAO;
import dao.TaskDAO;
import models.Member;
import models.Message;
import models.Task;

import java.util.List;

public class TaskServices {
    private TaskDAO taskDAO = new TaskDAO();

    public TaskServices() {
    }

    public Task find(int id) {
        return taskDAO.findById(id);
    }

    public void save(Task task){
        taskDAO.save(task);
    }

    public void update(Task task){
        taskDAO.update(task);
    }

    public void delete(Task task){
        taskDAO.delete(task);
    }

    public List<Task> findAll() {
        return taskDAO.findAll();
    }

    public void addFollower(Task task, Member member){
        task.addFollower(member);
        taskDAO.update(task);
    }

    public void addMessage(Task task, Message message){
        task.addMessage(message);
        taskDAO.update(task);
    }

    public void removeFollower(Task task, Member member){
        task.removeFollower(member);
        taskDAO.update(task);
    }

    public void removeMessage(Task task, Message message){
        task.removeMessage(message);
        taskDAO.update(task);
    }
}
