package com.deliverymatcher.backend.service;

import com.deliverymatcher.backend.model.City;
import com.deliverymatcher.backend.repository.CityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService (
            final CityRepository cityRepository
    ) {
        this.cityRepository = cityRepository;
    }

    public ResponseEntity<?> getAllCities () {
        List<City> cities = cityRepository.findAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
}
