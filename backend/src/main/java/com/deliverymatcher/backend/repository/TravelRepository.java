package com.deliverymatcher.backend.repository;

import com.deliverymatcher.backend.model.Journy;
import com.deliverymatcher.backend.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepository extends JpaRepository<Travel, Long> {
}
