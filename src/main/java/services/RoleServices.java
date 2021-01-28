package services;

import dao.RoleDAO;
import models.Role;

import java.util.List;

public class RoleServices {

    private RoleDAO roleDAO = new RoleDAO();

    public RoleServices() {
    }

    public Role find(int id) {
        return roleDAO.findById(id);
    }

    public void save(Role role){
        roleDAO.save(role);
    }

    public void update(Role role){
        roleDAO.update(role);
    }

    public void delete(Role role){
        roleDAO.delete(role);
    }

    public List<Role> findAll() {
        return roleDAO.findAll();
    }
}
