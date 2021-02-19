package org.etd.up.repo;

import org.etd.up.models.Project;
import org.etd.up.models.ProjectTask;
import org.etd.up.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    Project findById(int id);
}
