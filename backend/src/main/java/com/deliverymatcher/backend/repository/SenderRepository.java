package com.deliverymatcher.backend.repository;

import com.deliverymatcher.backend.model.Sender;
import com.deliverymatcher.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SenderRepository extends JpaRepository<Sender, Long> {
    public Sender findSenderByEmail(String email);

    public Sender findSenderById(Long id);
}
