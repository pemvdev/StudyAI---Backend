package com.ziros.studyAI.controller;

import com.ziros.studyAI.RegisterRequest;
import com.ziros.studyAI.dto.UserDTO;
import com.ziros.studyAI.exception.EmailAlreadyExistException;
import com.ziros.studyAI.repository.UserRepository;
import com.ziros.studyAI.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

}
