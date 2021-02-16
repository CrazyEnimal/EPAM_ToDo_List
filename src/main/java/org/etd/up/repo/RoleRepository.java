package org.etd.up.repo;

import org.etd.up.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findRoleByTitle(String title);
    Role findById(int id);
}
