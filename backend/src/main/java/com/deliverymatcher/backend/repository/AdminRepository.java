package com.deliverymatcher.backend.repository;

import com.deliverymatcher.backend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
