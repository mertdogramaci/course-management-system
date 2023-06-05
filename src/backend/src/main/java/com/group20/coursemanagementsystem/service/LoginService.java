package com.group20.coursemanagementsystem.service;

import com.group20.coursemanagementsystem.model.ProcessingHistory;
import com.group20.coursemanagementsystem.repository.ProcessingHistoryRepository;
import com.group20.coursemanagementsystem.request.LoginRequest;
import com.group20.coursemanagementsystem.response.LoginQueryResponse;
import com.group20.coursemanagementsystem.utils.JwtUtil;
import com.group20.coursemanagementsystem.response.MemberQueryResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class LoginService {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    private final AuthenticationManager authenticationManager;
    private final MemberService memberService;

    private final ProcessingHistoryRepository processingHistoryRepository;

    public LoginService(final AuthenticationManager authenticationManager,
                        final MemberService memberService, ProcessingHistoryRepository processingHistoryRepository) {
        this.authenticationManager = authenticationManager;
        this.memberService = memberService;
        this.processingHistoryRepository = processingHistoryRepository;
    }

    public LoginQueryResponse login(LoginRequest loginRequest) {
        // 2 param constructor => it is not authenticated!
        var token = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());

        try {
            Authentication authenticatedToken  = authenticationManager.authenticate(token);
            String jwt = JwtUtil.generateToken(authenticatedToken, secretKey);

            MemberQueryResponse memberQueryResponse = new MemberQueryResponse(memberService.getMemberByEmail(loginRequest.getEmail()));
            processingHistoryRepository.save(new ProcessingHistory(LocalDateTime.now(), "User with %s email address logged in".formatted(loginRequest.getEmail())));
            return new LoginQueryResponse(jwt, memberQueryResponse);
        }
        catch (AuthenticationException ex) {
            throw ex;
        }
    }
}
