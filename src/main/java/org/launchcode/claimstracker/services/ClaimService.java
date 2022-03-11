package org.launchcode.claimstracker.services;

import org.launchcode.claimstracker.data.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaimService {
    @Autowired
    ClaimRepository claimRepository;

    public void saveClaim() {

    }


}
