package org.launchcode.claimstracker.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue
    private int id;

    public int getId(){
        return id;
    }
}
