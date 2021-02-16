package org.etd.up.repo;

import org.etd.up.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Project findById(int id);
}
