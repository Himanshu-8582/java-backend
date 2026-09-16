package com.example.YamlAndProfile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @Value("${app.welcome.message}")
    private String message="";

    @Value(("${app.welcome.code}"))
    private Integer code;

    @Value(("${app.welcome.users}"))
    private List<String> names;

    @PostMapping("/greet")
    public ResponseEntity<String> greet(){
        System.out.println(names);
        return ResponseEntity.ok(message+" : "+code);
    }
}
