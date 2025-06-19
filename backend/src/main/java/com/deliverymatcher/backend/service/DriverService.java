package com.deliverymatcher.backend.service;

import com.deliverymatcher.backend.model.Driver;
import com.deliverymatcher.backend.repository.DriverRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService (
            final DriverRepository driverRepository
    ) {
        this.driverRepository = driverRepository;
    }

    public Driver findById ( Long id ) {
        return driverRepository.findDriverById( id );
    }

}
