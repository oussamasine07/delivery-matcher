package com.deliverymatcher.backend.service;

import com.deliverymatcher.backend.dto.MappedApplicationDTO;
import com.deliverymatcher.backend.dto.MappedPackageDTO;
import com.deliverymatcher.backend.mapper.ApplicationMapper;
import com.deliverymatcher.backend.model.Application;
import com.deliverymatcher.backend.model.Pack;
import com.deliverymatcher.backend.repository.AnnouncementRepository;
import com.deliverymatcher.backend.repository.ApplicationRapository;
import com.deliverymatcher.backend.repository.PackageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    private final ApplicationRapository applicationRapository;
    private final PackageRepository packageRepository;
    private final ApplicationMapper applicationMapper;
    private final AnnouncementRepository announcementRepository;

    public ApplicationService (
            final ApplicationRapository applicationRapository,
            final PackageRepository packageRepository,
            final ApplicationMapper applicationMapper,
            final AnnouncementRepository announcementRepository
    ) {
        this.applicationRapository = applicationRapository;
        this.packageRepository = packageRepository;
        this.applicationMapper = applicationMapper;
        this.announcementRepository = announcementRepository;
    }

    public ResponseEntity<?> apply (Application application, Pack pack) {
        pack.setApplication(application);
        Pack savedPack = packageRepository.save(pack);

        application.setPack(savedPack);

        application.getAnnouncement().getApplications().add(application);

        Application savedApplication = applicationRapository.save(application);

        Application newApplication = applicationRapository.findApplicationById( savedApplication.getId() );

        MappedApplicationDTO dto = applicationMapper.toDTO(newApplication);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    public ResponseEntity<?> getAllApplications () {
        List<MappedApplicationDTO> applications = applicationRapository.findAllWithPack()
                .stream()
                .map(applicationMapper::toDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

}
