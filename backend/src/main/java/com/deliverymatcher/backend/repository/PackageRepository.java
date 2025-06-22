package com.deliverymatcher.backend.repository;

import com.deliverymatcher.backend.model.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Pack, Long> {
}
