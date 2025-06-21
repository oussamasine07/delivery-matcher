package com.deliverymatcher.backend.controller;


import com.deliverymatcher.backend.dto.AnnouncementDTO;
import com.deliverymatcher.backend.dto.JournyDTO;
import com.deliverymatcher.backend.exception.NotFoundExeption;
import com.deliverymatcher.backend.model.City;
import com.deliverymatcher.backend.model.Journy;
import com.deliverymatcher.backend.model.JournyStatus;
import com.deliverymatcher.backend.repository.CityRepository;
import com.deliverymatcher.backend.service.JournyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/show/{id}")
    public ResponseEntity<?> showJourny (@PathVariable Long id) {
        return journyService.show( id );
    }

    @PostMapping("/create")
    public ResponseEntity<?> createJourny (@Valid @RequestBody JournyDTO journyDTO) {

        Journy journy = new Journy();

        journy.setName(journyDTO.name());

        City departureDestination = cityRepository.findCityById(journyDTO.departure_destination());
        journy.setDepartureDestination( departureDestination );

        City finalDestination = cityRepository.findCityById(journyDTO.final_destination());
        journy.setFinalDestination( finalDestination );

        List<City> passedByCities = journyDTO.passed_by_cities()
                .stream()
                .map(cityId -> {
                    return cityRepository.findCityById(cityId);
                })
                .collect(Collectors.toList());

        journy.setPassedByCities( passedByCities );

        return journyService.create(journy);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJourny (@Valid @RequestBody JournyDTO journyDTO, @PathVariable Long id) {

        Journy journy = new Journy();

        journy.setName(journyDTO.name());

        City departureDestination = cityRepository.findCityById(journyDTO.departure_destination());
        journy.setDepartureDestination( departureDestination );

        City finalDestination = cityRepository.findCityById(journyDTO.final_destination());
        journy.setFinalDestination( finalDestination );

        if ( journyDTO.passed_by_cities() != null ) {
            List<City> passedByCities = journyDTO.passed_by_cities()
                    .stream()
                    .map(cityId -> {
                        return cityRepository.findCityById(cityId);
                    })
                    .collect(Collectors.toList());

            journy.setPassedByCities( passedByCities );
        }

        return journyService.update(journy, id);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJourny(@PathVariable Long id) {
        return journyService.delete( id );
    }


}
