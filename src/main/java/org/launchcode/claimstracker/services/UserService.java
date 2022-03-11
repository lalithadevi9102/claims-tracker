package org.launchcode.claimstracker.services;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.launchcode.claimstracker.data.UserRepository;
import java.util.*;
import javax.servlet.http.HttpSession;

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
