package org.etd.up.repo;

import org.etd.up.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepositiry extends JpaRepository<Event, Integer> {
    Event findById(int id);
}
