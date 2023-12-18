package com.aaa.projekt.services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String hello() {
        return "Witaj na mojej stronie, fajna strona";
    }
}