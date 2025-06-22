package com.deliverymatcher.backend.repository;

import com.deliverymatcher.backend.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    @Query(value = "select * from announcements where driver_id = ?", nativeQuery = true)
    public List<Announcement> findAnnouncementsByDriverId (Long dirverId);

    Announcement findAnnouncementById(Long id);
}
