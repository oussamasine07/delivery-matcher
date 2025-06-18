package com.deliverymatcher.backend.controller;



import com.deliverymatcher.backend.dto.TravelDTO;
import com.deliverymatcher.backend.model.City;
import com.deliverymatcher.backend.model.Journy;
import com.deliverymatcher.backend.model.JournyStatus;
import com.deliverymatcher.backend.model.Travel;
import com.deliverymatcher.backend.repository.JournyRepository;
import com.deliverymatcher.backend.service.TravelService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/travel")
public class TravelController {

    private final TravelService travelService;
    private final JournyRepository journyRepository;

    public TravelController (
            final TravelService travelService,
            JournyRepository journyRepository) {
        this.travelService = travelService;
        this.journyRepository = journyRepository;
    }

    //@GetMapping
//    public ResponseEntity<?> getJournies () {
//        return journyService.index();
//    }
//
//    @GetMapping("/show/{id}")
//    public ResponseEntity<?> showJourny (@PathVariable Long id) {
//        return journyService.show( id );
//    }

    @PostMapping("/create")
    public ResponseEntity<?> createTravel (@Valid @RequestBody TravelDTO travelDTO) {

        Travel travel = new Travel();

        travel.setDate( travelDTO.date() );
        travel.setTakeOff( travelDTO.take_off() );
        travel.setArrivedAt( travelDTO.arrived_at() );
        travel.setJournyStatus(travelDTO.journy_status());

        if (travelDTO.journy_id() != null) {
            Journy journy = journyRepository.findJournyById(travelDTO.journy_id());
            travel.setJourny(journy);
        }

        return travelService.create(travel);
    }

}
