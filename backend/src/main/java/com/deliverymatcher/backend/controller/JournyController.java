package com.deliverymatcher.backend.controller;


import com.deliverymatcher.backend.dto.AnnouncementDTO;
import com.deliverymatcher.backend.dto.JournyDTO;
import com.deliverymatcher.backend.model.City;
import com.deliverymatcher.backend.model.Journy;
import com.deliverymatcher.backend.repository.CityRepository;
import com.deliverymatcher.backend.service.JournyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/journy")
public class JournyController {

    private final JournyService journyService;
    private final CityRepository cityRepository;

    public JournyController (
            final JournyService journyService,
            final CityRepository cityRepository
    ) {
        this.journyService = journyService;
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public ResponseEntity<?> getJournies () {
        return journyService.index();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createJourny (@Valid @RequestBody JournyDTO journyDTO) {

        Journy journy = new Journy();

        journy.setDate( journyDTO.date() );
        journy.setTakeOffAt( journyDTO.take_off_at() );
        journy.setArrivedAt( journyDTO.arrived_at() );

        City city = cityRepository.findById(journyDTO.road_to()).orElseThrow();

        journy.setRoadTo( city );


        return journyService.create(journy);
    }


}
