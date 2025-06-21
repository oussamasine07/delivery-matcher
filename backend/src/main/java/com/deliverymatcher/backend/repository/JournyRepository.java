package com.deliverymatcher.backend.repository;

import com.deliverymatcher.backend.model.Journy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JournyRepository extends JpaRepository<Journy, Long> {
    public Journy findJournyById( Long id );

    @Query(value = "select * from journies where announcement_id = ?", nativeQuery = true)
    public List<Journy> findJourniesByAnnouncementId( Long announcmentId );
}
