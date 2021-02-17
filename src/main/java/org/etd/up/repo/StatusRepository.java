package org.etd.up.repo;

import org.etd.up.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
    Status findById(int id);
}
