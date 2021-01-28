package services;

import dao.TeamDAO;
import models.Team;

import java.util.List;

public class TeamServices {

    private TeamDAO teamDAO = new TeamDAO();

    public TeamServices() {
    }

    public Team find(int id) {
        return teamDAO.findById(id);
    }

    public void save(Team team){
        teamDAO.save(team);
    }

    public void update(Team team){
        teamDAO.update(team);
    }

    public void delete(Team team){
        teamDAO.delete(team);
    }

    public List<Team> findAll() {
        return teamDAO.findAll();
    }
}
