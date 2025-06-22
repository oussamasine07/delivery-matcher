package com.deliverymatcher.backend.repository;

import com.deliverymatcher.backend.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package, Long> {
}
