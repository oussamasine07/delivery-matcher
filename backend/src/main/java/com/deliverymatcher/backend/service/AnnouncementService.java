package com.deliverymatcher.backend.service;

import com.deliverymatcher.backend.model.Announcement;
import com.deliverymatcher.backend.model.Travel;
import com.deliverymatcher.backend.repository.AnnouncementRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    public AnnouncementService (
            final AnnouncementRepository announcementRepository
    ) {
        this.announcementRepository = announcementRepository;
    }

    public ResponseEntity<?> fetchAnnouncementsDriverId (Long id) {
        List<Announcement> announcements = announcementRepository.findAnnouncementsByDriverId( id );
        return new ResponseEntity<>(announcements, HttpStatus.OK);
    }

    public ResponseEntity<?> create (Announcement announcement) {

        Announcement newAnnouncement = announcementRepository.save(announcement);

        return new ResponseEntity<>(newAnnouncement, HttpStatus.OK);
    }

}
