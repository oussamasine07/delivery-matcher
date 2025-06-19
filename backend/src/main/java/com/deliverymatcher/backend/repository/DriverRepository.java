package com.deliverymatcher.backend.repository;

import com.deliverymatcher.backend.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    public Driver findDriverByEmail(String email);
    public Driver findDriverById( Long id );
}
