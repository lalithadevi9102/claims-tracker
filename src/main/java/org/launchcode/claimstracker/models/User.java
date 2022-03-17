package org.launchcode.claimstracker.models;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends AbstractEntity {

    @Email
    @NotNull
    private String username;
    //username = email address

    @NotNull
    private String pwHash;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user")
    private final List<Bill> bills = new ArrayList<>();

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public List<Bill> getBills() {
        return bills;
    }

    public List<String> billsToJson() {
        List<String> billsAsString = new ArrayList<>();
        for (Bill bill : bills) {
            String billAsString = bill.toJson();
            billsAsString.add(billAsString);
        }
        return billsAsString;
    }
}