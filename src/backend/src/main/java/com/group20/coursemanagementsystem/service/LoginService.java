package com.group20.coursemanagementsystem.service;

import com.group20.coursemanagementsystem.request.LoginRequest;
import com.group20.coursemanagementsystem.response.LoginQueryResponse;
import com.group20.coursemanagementsystem.utils.JwtUtil;
import com.group20.coursemanagementsystem.response.MemberQueryResponse;
import com.group20.coursemanagementsystem.model.Member;
import com.group20.coursemanagementsystem.service.MemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    private final AuthenticationManager authenticationManager;
    private final MemberService memberService;

    public LoginService(final AuthenticationManager authenticationManager,
                        final MemberService memberService) {
        this.authenticationManager = authenticationManager;
        this.memberService = memberService;
    }

    public LoginQueryResponse login(LoginRequest loginRequest) {
        // 2 param constructor => it is not authenticated!
        var token = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());

        try {
            Authentication authenticatedToken  = authenticationManager.authenticate(token);
            String jwt = JwtUtil.generateToken(authenticatedToken, secretKey);

            MemberQueryResponse memberQueryResponse = new MemberQueryResponse(memberService.getMemberByEmail(loginRequest.getEmail()));
            return new LoginQueryResponse(jwt, memberQueryResponse);
        }
        catch (AuthenticationException ex) {
            throw ex;
        }
    }
}
