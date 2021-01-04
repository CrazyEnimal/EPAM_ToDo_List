package services;

import dao.RoleDAO;
import models.Role;

import java.util.List;

public class RoleServices {

    private RoleDAO roleDAO = new RoleDAO();

    public RoleServices() {
    }

    public Role findRole(int id) {
        return roleDAO.findById(id);
    }

    public void saveRole(Role role){
        roleDAO.save(role);
    }

    public void updateRole(Role role){
        roleDAO.update(role);
    }

    public void deleteRole(Role role){
        roleDAO.delete(role);
    }

    public List<Role> findAllRoles() {
        return roleDAO.findAll();
    }
}
