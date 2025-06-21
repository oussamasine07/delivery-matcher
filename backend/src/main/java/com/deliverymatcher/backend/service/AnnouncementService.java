package com.deliverymatcher.backend.service;

import com.deliverymatcher.backend.dto.MappedAnnouncmentDTO;
import com.deliverymatcher.backend.dto.MappedJournyDTO;
import com.deliverymatcher.backend.exception.NotFoundExeption;
import com.deliverymatcher.backend.mapper.AnnouncementMapper;
import com.deliverymatcher.backend.mapper.JournyMapper;
import com.deliverymatcher.backend.model.Announcement;
import com.deliverymatcher.backend.model.Journy;
import com.deliverymatcher.backend.model.Travel;
import com.deliverymatcher.backend.repository.AnnouncementRepository;
import com.deliverymatcher.backend.repository.JournyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final JournyRepository journyRepository;
    private final JournyMapper journyMapper;
    private final AnnouncementMapper announcementMapper;

    public AnnouncementService (
            final AnnouncementRepository announcementRepository,
            final JournyRepository journyRepository,
            final JournyMapper journyMapper,
            final AnnouncementMapper announcementMapper
    ) {
        this.announcementRepository = announcementRepository;
        this.journyRepository = journyRepository;
        this.journyMapper = journyMapper;
        this.announcementMapper = announcementMapper;
    }

    public ResponseEntity<?> getAnnouncements () {
        List<MappedAnnouncmentDTO> announcements = announcementRepository.findAll()
                .stream()
                .map(this.announcementMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(announcements, HttpStatus.OK);
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

    public ResponseEntity<?> update (Announcement announcement, Long id, Long driverId) {
        Announcement updatedAnnouncement = announcementRepository.findById(id)
                .orElseThrow(() -> new NotFoundExeption("you can't update unfound announcement"));

        if (updatedAnnouncement.getDriver().getId() == driverId) {
            updatedAnnouncement.setName( announcement.getName() );
            updatedAnnouncement.setMaxDimentions( announcement.getMaxDimentions() );
            updatedAnnouncement.setGoodsType( announcement.getGoodsType() );
            updatedAnnouncement.setCapacity( announcement.getCapacity() );
            updatedAnnouncement.setJourny( announcement.getJourny() );

            return new ResponseEntity<>(announcementRepository.save(updatedAnnouncement), HttpStatus.OK);
        }

        Map<String, String> error = new HashMap<>();
        error.put("message", "Unauthorized action");

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> delete ( Long announcementId, Long driverId ) {
        Announcement deletedAnnouncement = announcementRepository.findById(announcementId)
                .orElseThrow(() -> new NotFoundExeption("you can't delete unfound announcement"));

        if (deletedAnnouncement.getDriver().getId() == driverId) {

            announcementRepository.deleteById( announcementId );
            Map<String, Object> deleted = new HashMap<>();
            deleted.put("success", deletedAnnouncement.getName() + " has been deleted");
            deleted.put("announcement", deletedAnnouncement);

            return new ResponseEntity<>(deleted, HttpStatus.OK);

        }
        Map<String, String> error = new HashMap<>();
        error.put("error", "Unauthorized action");

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
