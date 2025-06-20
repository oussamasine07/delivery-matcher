package com.deliverymatcher.backend.service;

import com.deliverymatcher.backend.dto.MappedAnnouncmentDTO;
import com.deliverymatcher.backend.dto.MappedJournyDTO;
import com.deliverymatcher.backend.mapper.AnnouncementMapper;
import com.deliverymatcher.backend.mapper.JournyMapper;
import com.deliverymatcher.backend.model.Announcement;
import com.deliverymatcher.backend.model.Travel;
import com.deliverymatcher.backend.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final JournyMapper journyMapper;
    private final AnnouncementMapper announcementMapper;

    public AnnouncementService (
            final AnnouncementRepository announcementRepository,
            final JournyMapper journyMapper,
            final AnnouncementMapper announcementMapper
    ) {
        this.announcementRepository = announcementRepository;
        this.journyMapper = journyMapper;
        this.announcementMapper = announcementMapper;
    }

    public ResponseEntity<?> fetchAnnouncementsDriverId (Long id) {
        List<MappedAnnouncmentDTO> announcements = announcementRepository.findAnnouncementsByDriverId( id )
                .stream()
                .map(this.announcementMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(announcements, HttpStatus.OK);
    }

    public ResponseEntity<?> create (Announcement announcement) {

        Announcement newAnnouncement = announcementRepository.save(announcement);

        return new ResponseEntity<>(newAnnouncement, HttpStatus.OK);
    }

}
