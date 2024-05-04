package com.aaa.projekt.controller;

import com.aaa.projekt.Repository.AuthoritiesRepository;
import com.aaa.projekt.config.LoginCredentials;
import com.aaa.projekt.model.Authorities;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    private final AuthoritiesRepository authoritiesRepository;

    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials credentials) {
    }

    @GetMapping("/authority")
    public List<Authorities> getAuthority(@RequestParam(required = false) Integer page) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        return authoritiesRepository.findAllUsers(PageRequest.of(pageNumber, 5));
    }
}
