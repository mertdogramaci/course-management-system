package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.repository.ProcessingHistoryRepository;
import com.group20.coursemanagementsystem.request.LoginRequest;
import com.group20.coursemanagementsystem.response.LoginQueryResponse;
import com.group20.coursemanagementsystem.service.LoginService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public LoginQueryResponse login(@Valid @RequestBody final LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }
}
