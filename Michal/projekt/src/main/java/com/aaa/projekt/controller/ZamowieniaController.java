package com.aaa.projekt.controller;

import com.aaa.projekt.config.RegisterCredentials;
import com.aaa.projekt.model.Zamowienia;
import com.aaa.projekt.services.ZamowieniaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ZamowieniaController {

        private final ZamowieniaService zamowieniaService;

        @GetMapping("/zamowienia")
        public List<Zamowienia> getZamowienia(@RequestParam(required = false) Integer page) {
            int pageNumber = page != null && page >= 0 ? page : 0;
            return zamowieniaService.getZamowienia(pageNumber);
        }

        @GetMapping("/zamowienia/{id}")
        public Zamowienia getZamowieniaById(@PathVariable("id") long id) {
            return zamowieniaService.getSingleZamowienie(id);
        }

        @PutMapping("/zamowienia")
        public Zamowienia addZamowienia(@RequestBody Zamowienia zamowienia) {
            return zamowieniaService.addZamowienie(zamowienia);
        }

        @PostMapping("/zamowienia")
        public Zamowienia addZamowieniaDWA(@RequestBody Zamowienia zamowienia) {
            return zamowieniaService.addZamowieniaDWA(zamowienia);
        }

        @DeleteMapping("/zamowienia/{id}")
        public void deleteZamowienia(@PathVariable("id") long id) {
            zamowieniaService.deleteSingleZamowienia(id);
        }
    }

