package com.deliverymatcher.backend.controller;

import com.deliverymatcher.backend.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/city")
public class CityController {

    private final CityService cityService;

    public CityController (
            final CityService cityService
    ) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<?> getCities () {
        return cityService.getAllCities();
    }

}
