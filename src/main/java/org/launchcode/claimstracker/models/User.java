package org.launchcode.claimstracker.models;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.google.gson.Gson;
import javax.persistence.*;
import com.sun.istack.NotNull;
import javax.validation.constraints.Email;
import java.util.*;

@Entity
@Table(name = "user")
public class User extends AbstractEntity {
    @Email
    @NotNull
    private String userName; // userName = email address...
    private String pwHash;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user")
    private final List<Claim> claims = new ArrayList<>();

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(String username, String password, String firstName, String lastName) {
        this.userName = username;
        this.pwHash = encoder.encode(password);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return userName;
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

    public List<Claim> getClaims() {
        return claims;
    }


}
