package com.deliverymatcher.backend.repository;

import com.deliverymatcher.backend.model.Journy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournyRepository extends JpaRepository<Journy, Long> {
    public Journy findJournyById( Long id );
}
