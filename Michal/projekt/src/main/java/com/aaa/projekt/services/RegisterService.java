package com.aaa.projekt.services;

import com.aaa.projekt.config.CustomUserDetails;
import com.aaa.projekt.config.CustomUserDetailsManager;
import com.aaa.projekt.services.Interface.RegisterInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class RegisterService implements RegisterInterface {

    private final CustomUserDetailsManager customUserDetailsManager;

    @Override
    public void register(String username, String password, String email) {

        String encodedPassword = "{bcrypt}" + new BCryptPasswordEncoder().encode(password);
        GrantedAuthority authority = new SimpleGrantedAuthority("USER");
        customUserDetailsManager.saveUser(new CustomUserDetails(username, encodedPassword, email, true, Collections.singletonList(authority)));
    }
}
