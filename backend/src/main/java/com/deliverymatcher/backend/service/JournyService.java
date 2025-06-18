package com.deliverymatcher.backend.service;

import com.deliverymatcher.backend.dto.JournyDTO;
import com.deliverymatcher.backend.model.Journy;
import com.deliverymatcher.backend.repository.JournyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class JournyService {

    private final JournyRepository journyRepository;

    public JournyService (
            final JournyRepository journyRepository
    ) {
        this.journyRepository = journyRepository;
    }

    public ResponseEntity<?> create (Journy journy) {
        Journy newJourny = journyRepository.save( journy );
        return new ResponseEntity<>(newJourny, HttpStatus.OK);
    }
}
















