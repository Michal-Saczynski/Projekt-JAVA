package com.aaa.projekt.controller;
import com.aaa.projekt.model.Uzytkownicy;
import com.aaa.projekt.services.UzytkownicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")



public class UzytkownicyController {
    private final UzytkownicyService uzytkownicyService;

    @GetMapping("/uzytkownicy")
    public List<Uzytkownicy> getUzytkownicy(@RequestParam(required = false) Integer page) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        return uzytkownicyService.getUzytkownicy(pageNumber);
    }

    @GetMapping("/uzytkownicy/{id}")
    public Uzytkownicy getUzytkownicyById(@PathVariable("id") long id) {
        return uzytkownicyService.getSingleUzytkownicy(id);
    }

    @PutMapping("/uzytkownicy")
    public Uzytkownicy addUzytkownicy(@RequestBody Uzytkownicy uzytkownicy) {
        return uzytkownicyService.adduzytkownicy(uzytkownicy);
    }

    @DeleteMapping("/uzytkownicy/{id}")
    public void deleteUzytkownicy(@PathVariable("id") long id) {
        uzytkownicyService.deleteSingleUzytkownicy(id);
    }
}

