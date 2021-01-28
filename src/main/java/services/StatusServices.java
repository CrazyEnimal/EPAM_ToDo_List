package services;

import dao.StatusDAO;
import models.Status;

import java.util.List;

public class StatusServices {

    private StatusDAO statusDAO;

    public StatusServices() {
    }

    public Status find(int id) {
        return statusDAO.findById(id);
    }

    public void save(Status status){
        statusDAO.save(status);
    }

    public void update(Status status){
        statusDAO.update(status);
    }

    public void delete(Status status){
        statusDAO.delete(status);
    }

    public List<Status> findAll() {
        return statusDAO.findAll();
    }
}
