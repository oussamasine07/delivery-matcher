package com.deliverymatcher.backend.service;


import com.deliverymatcher.backend.exception.NotFoundExeption;
import com.deliverymatcher.backend.model.Journy;
import com.deliverymatcher.backend.model.Travel;
import com.deliverymatcher.backend.repository.TravelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TravelService {

    private final TravelRepository travelRepository;

    public TravelService (
            final TravelRepository travelRepository
    ) {
        this.travelRepository = travelRepository;
    }

    public ResponseEntity<?> index () {
        List<Travel> travels = travelRepository.findAll();
        return new ResponseEntity<>(travels, HttpStatus.OK);
    }

    public ResponseEntity<?> show (Long id) {
        Travel travel = travelRepository.findById( id )
                .orElseThrow( () -> new NotFoundExeption("this travel not found") );
        return new ResponseEntity<>(travel, HttpStatus.OK);
    }

    public ResponseEntity<?> create (Travel travel) {

        Travel newTravel = travelRepository.save(travel);
        return new ResponseEntity<>(newTravel, HttpStatus.OK);

    }

    public ResponseEntity<?> update (Travel travel, Long id) {

        Travel updatedTravel = travelRepository.findById( id )
                .orElseThrow(() -> new NotFoundExeption("you can't update a not found travel"));

        updatedTravel.setDate(travel.getDate());
        updatedTravel.setTakeOff(travel.getTakeOff());
        updatedTravel.setArrivedAt(travel.getArrivedAt());
        updatedTravel.setJournyStatus(travel.getJournyStatus());

        if (travel.getJourny() != null ) updatedTravel.setJourny( travel.getJourny() );

        return new ResponseEntity<>(travelRepository.save(updatedTravel), HttpStatus.OK);

    }

    public ResponseEntity<?> delete (Long id) {
        Travel travel = travelRepository.findById( id )
                .orElseThrow(() -> new NotFoundExeption("you can't update a not found travel"));
        Map<String, String> res = new HashMap<>();

        res.put("id", travel.getId().toString());

        travelRepository.deleteById( id );
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}












