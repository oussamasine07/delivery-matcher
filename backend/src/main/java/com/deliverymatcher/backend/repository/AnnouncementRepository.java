package com.deliverymatcher.backend.repository;

import com.deliverymatcher.backend.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    @Query(value = "select * from announcements where driver_id = ?", nativeQuery = true)
    public List<Announcement> findAnnouncementsByDriverId (Long dirverId);

    Announcement findAnnouncementById(Long id);

    @Query("SELECT DISTINCT a FROM Announcement a LEFT JOIN FETCH a.applications LEFT JOIN FETCH a.journy")
    List<Announcement> findAllWithApplications();

    @Query(value = "select * from announcements\n" +
            "inner join applications\n" +
            "on applications.annoucement_id = announcements.id\n" +
            "inner join sender\n" +
            "on senders.id = announcements.sender_id\n" +
            "where sender.id = ?", nativeQuery = true)
    List<Announcement> getAnnouncementsBySenderId( Long senderId );
}
