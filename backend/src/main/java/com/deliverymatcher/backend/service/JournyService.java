package com.deliverymatcher.backend.service;

import com.deliverymatcher.backend.dto.JournyDTO;
import com.deliverymatcher.backend.exception.NotFoundExeption;
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
        Journy journy = journyRepository.findById( id )
                .orElseThrow( () -> new NotFoundExeption("journy not found") );
        return new ResponseEntity<>(journy, HttpStatus.OK);
    }

    public ResponseEntity<?> create (Journy journy) {
        Journy newJourny = journyRepository.save( journy );
        return new ResponseEntity<>(newJourny, HttpStatus.OK);
    }

    public ResponseEntity<?> update (Journy journy, Long id) {

        Journy updateJourny = journyRepository.findById( id )
                .orElseThrow( () -> new NotFoundExeption("you can't update a not found journy") );

        updateJourny.setName(journy.getName());
        updateJourny.setDepartureDestination(journy.getDepartureDestination());
        updateJourny.setFinalDestination(journy.getFinalDestination());
        updateJourny.setPassedByCities(journy.getPassedByCities());


        return new ResponseEntity(journyRepository.save( updateJourny ), HttpStatus.OK);

    }

    public ResponseEntity<?> delete (Long id) {
        Journy journy = journyRepository.findById( id ).orElseThrow( () -> new NotFoundExeption("you can't delete a not found journy") );
        Map<String, String> res = new HashMap<>();

        res.put("id", journy.getId().toString());

        journyRepository.deleteById( id );
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public Journy getJournyById ( Long id ) {
        return journyRepository.findJournyById( id );
    }

}
















