package com.deliverymatcher.backend.repository;

import com.deliverymatcher.backend.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    public City findCityById(Long id);
}
