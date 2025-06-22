package com.deliverymatcher.backend.service;

import com.deliverymatcher.backend.model.Application;
import com.deliverymatcher.backend.model.Package;
import com.deliverymatcher.backend.repository.ApplicationRapository;
import com.deliverymatcher.backend.repository.PackageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    private final ApplicationRapository applicationRapository;
    private final PackageRepository packageRepository;

    public ApplicationService (
            final ApplicationRapository applicationRapository,
            final PackageRepository packageRepository
    ) {
        this.applicationRapository = applicationRapository;
        this.packageRepository = packageRepository;
    }

    public ResponseEntity<?> apply (Application application, Package pack) {
        Application newApplication = applicationRapository.save( application );
        Package newPack = packageRepository.save(pack);

        newApplication.setPack( newPack );
        newPack.setApplication( newApplication );

        applicationRapository.save(newApplication);
        packageRepository.save(newPack);
        return new ResponseEntity<>(newApplication, HttpStatus.OK);
    }

}
