package com.deliverymatcher.backend.service;

import com.deliverymatcher.backend.mapper.JournyMapper;
import com.deliverymatcher.backend.model.City;
import com.deliverymatcher.backend.model.Journy;
import com.deliverymatcher.backend.repository.JournyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JournyServiceTest {

    @Mock
    JournyRepository journyRepository;

    private JournyService journyService;

    private final JournyMapper journyMapper = Mappers.getMapper(JournyMapper.class);

    @Test
    void index () {
        City city = new City();
        city.setId(1L);
        city.setName("marakesh");

        City city1 = new City();
        city.setId(2L);
        city.setName("casablanca");

        List<City> passedByCities = new ArrayList<>();
        passedByCities.add(city1);
        passedByCities.add(city);

        Journy journy = new Journy();
        journy.setName("test 1");
        journy.setDepartureDestination(city1);
        journy.setFinalDestination(city);
        journy.setPassedByCities(passedByCities);

        List<Journy> journies = Arrays.asList(journy);

        when( journyRepository.findAll() ).thenReturn(journies);
        journyService = new JournyService(journyRepository, journyMapper);

        ResponseEntity<?> result = journyService.index();

        assertEquals(HttpStatus.OK, result.getStatusCode());

    }

}



















