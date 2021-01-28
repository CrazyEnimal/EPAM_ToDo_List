package services;

import dao.ProjectDAO;
import models.Member;
import models.Project;
import models.Task;

import java.util.List;

public class ProjectServices {

    private ProjectDAO projectDAO;

    public ProjectServices() {
    }

    public Project findById(int id) {
        return projectDAO.findById(id);
    }

    public void add(Project project){
        projectDAO.save(project);
    }

    public void addFolower(Project project, Member member){
        project.addFolower(member);
        projectDAO.update(project);
    }

    public void addTask(Project project, Task task){
        project.addTasks(task);
        projectDAO.update(project);
    }

    public void update(Project project){
        projectDAO.update(project);
    }

    public void delete(Project project){
        projectDAO.delete(project);
    }

    public List<Project> findAllProjects() {
        return projectDAO.findAll();
    }
}
