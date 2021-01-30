package com.up.team.service;


import com.up.team.dao.DAO;
import com.up.team.dao.ProjectDaoImpl;
import com.up.team.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private DAO<Project, Integer> projectDAO;

    public ProjectServiceImpl() {

    }

    @Override
    public void create(Project project) {
        projectDAO.create(project);
    }

    @Override
    public void update(Project project) {
        projectDAO.update(project);
    }

    @Override
    public void delete(Project project) {
        projectDAO.delete(project);
    }

    @Override
    public final Project read(int id) {
        return projectDAO.read(id);
    }
}
