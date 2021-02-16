package org.etd.up.rest;

import org.etd.up.models.Role;
import org.etd.up.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/roles")
public class RoleRestController {

    @Autowired
    RoleRepository roleRepository;

    @GetMapping
    Collection<Role> roles() {
        return this.roleRepository.findAll();
    }
}
