package com.ziros.studyAI.service;

import com.ziros.studyAI.RegisterRequest;
import com.ziros.studyAI.dto.LoginRequest;
import com.ziros.studyAI.exception.InvalidCredentialsException;
import com.ziros.studyAI.model.User;
import com.ziros.studyAI.repository.UserRepository;
import com.ziros.studyAI.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

    @Service
    public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // agora funciona

    @Autowired
    private JwtUtil jwtUtil;

    public User register(RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // hash
        return userRepository.save(user);
    }

    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(InvalidCredentialsException::new);

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        return jwtUtil.generateToken(user.getEmail(), user.getId());
    }
}
