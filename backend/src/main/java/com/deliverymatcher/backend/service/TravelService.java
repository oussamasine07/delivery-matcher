package com.deliverymatcher.backend.service;


import com.deliverymatcher.backend.model.Travel;
import com.deliverymatcher.backend.repository.TravelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TravelService {

    private final TravelRepository travelRepository;

    public TravelService (
            final TravelRepository travelRepository
    ) {
        this.travelRepository = travelRepository;
    }

    public ResponseEntity<?> create (Travel travel) {

        Travel newTravel = travelRepository.save(travel);

        return new ResponseEntity<>(newTravel, HttpStatus.OK);

    }

}
