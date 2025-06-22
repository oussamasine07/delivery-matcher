package com.deliverymatcher.backend.repository;

import com.deliverymatcher.backend.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApplicationRapository extends JpaRepository<Application, Long> {
}
