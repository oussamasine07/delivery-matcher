package com.deliverymatcher.backend.service;

import com.deliverymatcher.backend.dto.JournyDTO;
import com.deliverymatcher.backend.model.Journy;
import com.deliverymatcher.backend.repository.JournyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JournyService {

    private final JournyRepository journyRepository;

    public JournyService (
            final JournyRepository journyRepository
    ) {
        this.journyRepository = journyRepository;
    }

    public ResponseEntity<?> index () {
        List<Journy> journies = journyRepository.findAll();
        return new ResponseEntity<>(journies, HttpStatus.OK);
    }

    public ResponseEntity<?> show (Long id) {
        Journy journy = journyRepository.findById( id ).orElseThrow();
        return new ResponseEntity<>(journy, HttpStatus.OK);
    }

    public ResponseEntity<?> create (Journy journy) {
        Journy newJourny = journyRepository.save( journy );
        return new ResponseEntity<>(newJourny, HttpStatus.OK);
    }

    public ResponseEntity<?> update (Journy journy, Long id) {

        Journy updateJourny = journyRepository.findById( id ).orElseThrow();

        updateJourny.setDate( journy.getDate() );
        updateJourny.setTakeOffAt( journy.getTakeOffAt() );
        updateJourny.setArrivedAt( journy.getArrivedAt() );
        updateJourny.setRoadTo( journy.getRoadTo() );

        return new ResponseEntity(journyRepository.save( updateJourny ), HttpStatus.OK);

    }

    public ResponseEntity<?> delete (Long id) {
        Journy journy = journyRepository.findById( id ).orElseThrow();
        Map<String, String> res = new HashMap<>();

        res.put("id", journy.getId().toString());
        res.put("road_to", journy.getRoadTo().getName());

        journyRepository.deleteById( id );
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
















