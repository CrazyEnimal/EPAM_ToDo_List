package com.up.team.service;


import com.up.team.dao.DAO;
import com.up.team.dao.ProjectDao;
import com.up.team.entity.Project;

public class ProjectService {
    private final DAO<Project, Integer> projectDAO = new ProjectDao();

    public ProjectService() {

    }

    public void create(Project project) {
        projectDAO.create(project);
    }

    public void update(Project project) {
        projectDAO.update(project);
    }

    public void delete(Project project) {
        projectDAO.delete(project);
    }

    public final Project read(int id) {
        return projectDAO.read(id);
    }
}
