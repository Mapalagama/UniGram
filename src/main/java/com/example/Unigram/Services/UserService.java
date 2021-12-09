package com.example.Unigram.Services;

import com.example.Unigram.Models.User;
import com.example.Unigram.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User createUser(User user) {
        if (userRepository.findFirstByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException();
        }
        return userRepository.save(user);

    }


    @EventListener(ApplicationReadyEvent.class)
    public void createAdmin() {

        User user = new User();
        user.setName("hasitha");
        user.setMobile("075685243");
        user.setEmail("kalanamapalagama.com");
        user.setPassword(new BCryptPasswordEncoder().encode("1234"));
        user.setRole("admin");

        try {
            User AdminUser = createUser(user);

        } catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println("admin already exist");
        }

    }

    public User login(User user) {
        Optional<User> user1 = userRepository.findFirstByEmail(user.getEmail());
        if (user1.isEmpty()) {
            throw new RuntimeException("username or password is incorrect");
        }
        User user2 = user1.get();
        if (!Objects.equals(user2.getPassword(), user.getPassword())) {
            throw new RuntimeException("username or password incorrect");
        }
        return user2;
    }

    public Optional<User> getUserByEmail(String email) {
        Optional<User> user = userRepository.findFirstByEmail(email);
        User user1 = user.get();
        return user;
    }
}
