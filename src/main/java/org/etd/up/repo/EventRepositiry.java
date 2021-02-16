package org.etd.up.repo;

import org.etd.up.models.Event;
import org.etd.up.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface EventRepositiry extends JpaRepository<Event, Integer> {
    Event findById(int id);
}
