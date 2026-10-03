package com.example.SpringSecurityDemo.service;


import com.example.SpringSecurityDemo.dto.UserRegisterRequestDto;
import com.example.SpringSecurityDemo.dto.UserRegisterResponseDto;
import com.example.SpringSecurityDemo.entity.Role;
import com.example.SpringSecurityDemo.entity.User;
import com.example.SpringSecurityDemo.repository.RoleRepository;
import com.example.SpringSecurityDemo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
//    private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository,RoleRepository roleRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository=roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRegisterResponseDto register(UserRegisterRequestDto requestDto){
        User user=new User();
        user.setUsername(requestDto.getUsername());
        String encodedPassword=passwordEncoder.encode(requestDto.getPassword());
        user.setPassword(encodedPassword);
        user.setEnable(true);

        Role role=roleRepository.findByName("USER").get();
        user.getRoles().add(role);
        userRepository.save(user);

        UserRegisterResponseDto res=new UserRegisterResponseDto();
        res.setUsername(user.getUsername());
        res.setMessage("User saved");
        return res;
    }

//    public Boolean login(UserRegisterRequestDto requestDto){
//        Optional<User> userOptional=userRepository.findByUsername(requestDto.getUsername());
//        User user=userOptional.get();
//        return passwordEncoder.matches(requestDto.getPassword(),user.getPassword());
//    }
}
