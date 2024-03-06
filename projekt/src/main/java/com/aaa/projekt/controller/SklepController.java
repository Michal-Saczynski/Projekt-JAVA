package com.aaa.projekt.controller;

import com.aaa.projekt.model.Produkty;
import com.aaa.projekt.model.Uzytkownicy;
import com.aaa.projekt.services.ProduktyService;
import com.aaa.projekt.services.UzytkownicyService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController

public class SklepController {
    private final ProduktyService produktyService;
@CrossOrigin
    @GetMapping("/produkty")
    public List<Produkty> getProdukty(@RequestParam(required = false) Integer page) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        return produktyService.getProdukty(pageNumber);

    }
}

