package com.singtome.domain.controller;

import com.singtome.domain.entity.User;
import com.singtome.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 로그인 요청
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User existingUser;
        existingUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (existingUser != null) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }

}
