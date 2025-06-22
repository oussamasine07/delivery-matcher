package com.deliverymatcher.backend.repository;

import com.deliverymatcher.backend.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ApplicationRapository extends JpaRepository<Application, Long> {
    Application findApplicationById(Long id);

    @Query("SELECT a FROM Application a LEFT JOIN FETCH a.pack")
    List<Application> findAllWithPack();
}
