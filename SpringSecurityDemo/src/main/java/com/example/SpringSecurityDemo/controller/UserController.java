package com.example.SpringSecurityDemo.controller;

import com.example.SpringSecurityDemo.dto.UserRegisterRequestDto;
import com.example.SpringSecurityDemo.dto.UserRegisterResponseDto;
import com.example.SpringSecurityDemo.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/hello")
    public String sayHello(Authentication authentication){
        return "Hello , You are logged in as : "+ authentication.getName();
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> register(@RequestBody UserRegisterRequestDto requestDto){
        UserRegisterResponseDto res = authService.register(requestDto);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/csrf")
    public CsrfToken getToken(CsrfToken csrfToken){
        return csrfToken;
    }

//    @GetMapping("/login")
//    public ResponseEntity<Boolean> login(@RequestBody UserRegisterRequestDto requestDto){
//        Boolean isLoggedIn=authService.login(requestDto);
//        return ResponseEntity.ok(isLoggedIn);
//    }
}
