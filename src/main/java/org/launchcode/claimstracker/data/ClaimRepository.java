package org.launchcode.claimstracker.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.launchcode.claimstracker.models.Claim;

@Repository
public interface ClaimRepository extends CrudRepository<Claim, Integer> {

}
