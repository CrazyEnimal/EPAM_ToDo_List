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

    public void saveMember(Role role){
        roleDAO.save(role);
    }

    public void updateMember(Role role){
        roleDAO.update(role);
    }

    public void deleteMember(Role role){
        roleDAO.delete(role);
    }

    public List<Role> findAllRoles() {
        return roleDAO.findAll();
    }
}
