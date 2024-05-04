package com.aaa.projekt.controller;

import com.aaa.projekt.config.RegisterCredentials;
import com.aaa.projekt.services.Interface.RegisterInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterController {

    private final RegisterInterface registerService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterCredentials credentials) {
        registerService.register(credentials.getUsername(), credentials.getPassword(), credentials.getEmail());
    }
}