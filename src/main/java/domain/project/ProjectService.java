package domain.project;

import domain.DAO;

public class ProjectService {
    private final DAO<Project, Integer> projectDAO = new ProjectDAO();

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
