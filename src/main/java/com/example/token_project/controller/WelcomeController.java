package com.example.token_project.controller;

import com.example.token_project.entity.AuthRequest;
import com.example.token_project.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class WelcomeController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public  String Welcome (){
        return  "Welcome to My APP";
    }
    @PostMapping("/authenticate")
    public  String generateToken(@RequestBody  AuthRequest authRequest) throws Exception {
    try {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

    }catch (Exception e){
    throw  new Exception("Invalid username/password");
    }

    return  jwtUtil.generateToken(authRequest.getUserName());
    }
    }
