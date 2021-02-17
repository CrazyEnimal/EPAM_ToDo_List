package org.etd.up.repo;

import org.etd.up.models.Task;
import org.etd.up.models.TaskFollower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Collection<TaskFollower> findAllByTaskFollowers(int task_id);
    Task findById(int id);
}
