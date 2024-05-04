package com.aaa.projekt.config;

import lombok.Getter;

@Getter
public class RegisterCredentials {
    private String username;
    private String password;
    private String email;
    private boolean enabled;
}