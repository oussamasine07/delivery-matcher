package com.deliverymatcher.backend.controller;


import com.deliverymatcher.backend.dto.AnnouncementDTO;
import com.deliverymatcher.backend.dto.JournyDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/journy")
public class JournyController {
    @PostMapping("/create")
    public ResponseEntity<?> createJourny (@Valid @RequestBody JournyDTO journyDTO) {
        return null;
    }
}
