package org.launchcode.claimstracker.services;

import org.launchcode.claimstracker.data.UserRepository;
import org.launchcode.claimstracker.models.Bill;
import org.launchcode.claimstracker.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findById(Integer userId) {
        Optional<User> optUser = userRepository.findById(userId);

        return (User) optUser.orElse(null);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}