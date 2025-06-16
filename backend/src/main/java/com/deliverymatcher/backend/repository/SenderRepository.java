package com.deliverymatcher.backend.repository;

import com.deliverymatcher.backend.model.Sender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SenderRepository extends JpaRepository<Sender, Long> {
}
