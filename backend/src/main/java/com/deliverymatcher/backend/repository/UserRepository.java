package com.deliverymatcher.backend.repository;

import com.deliverymatcher.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
