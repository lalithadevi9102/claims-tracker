package org.launchcode.claimstracker.services;

import org.launchcode.claimstracker.data.BillRepository;
import org.launchcode.claimstracker.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    BillRepository billRepository;

    public void saveBill(Bill newBill) {
        billRepository.save(newBill);
    }

    public void deleteById(int id) {
        billRepository.deleteById(id);
    }
}