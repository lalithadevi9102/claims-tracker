package org.launchcode.claimstracker.data;
import org.launchcode.claimstracker.models.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository<Bill, Integer> {


}
