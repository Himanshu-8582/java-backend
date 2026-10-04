package com.example.SpringSecurityDemo.controller;

import com.example.SpringSecurityDemo.dto.LoginReqDto;
import com.example.SpringSecurityDemo.dto.LoginResDto;
import com.example.SpringSecurityDemo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    private final ResourceLoader resourceLoader;

    public AuthController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostMapping("/login")
    public LoginResDto login(@RequestBody LoginReqDto loginReqDto){
        Authentication authenticationReq= UsernamePasswordAuthenticationToken.unauthenticated(
                loginReqDto.getUsername(),
                loginReqDto.getPassword()
        );

        Authentication authentication=authenticationManager.authenticate(authenticationReq);
        String token=jwtService.generateToken(authentication);
        return new LoginResDto(token);
    }
}
