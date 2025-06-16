package com.deliverymatcher.backend.service;

import com.deliverymatcher.backend.model.Admin;
import com.deliverymatcher.backend.model.Driver;
import com.deliverymatcher.backend.model.Sender;
import com.deliverymatcher.backend.repository.AdminRepository;
import com.deliverymatcher.backend.repository.DriverRepository;
import com.deliverymatcher.backend.repository.SenderRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final AdminRepository adminRepository;
    private final DriverRepository driverRepository;
    private final SenderRepository senderRepository;

    public UserService(
            final AdminRepository adminRepository,
            final DriverRepository driverRepository,
            final SenderRepository senderRepository
    ) {
        this.adminRepository = adminRepository;
        this.driverRepository = driverRepository;
        this.senderRepository = senderRepository;
    }

    public Admin findAdminByEmail (String email) {
        return adminRepository.findAdminByEmail(email);
    }

    public Sender findSenderByEmail (String email) {
        return senderRepository.findSenderByEmail(email);
    }

    public Driver findDriverByEmail ( String email ) {
        return driverRepository.findDriverByEmail( email );
    }

}
