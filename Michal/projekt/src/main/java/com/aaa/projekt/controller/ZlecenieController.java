package com.aaa.projekt.controller;

import com.aaa.projekt.config.RegisterCredentials;
import com.aaa.projekt.model.Produkty;
import com.aaa.projekt.model.Users;
import com.aaa.projekt.model.Zlecenie;
import com.aaa.projekt.services.ZlecenieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ZlecenieController {

    private final ZlecenieService zlecenieService;

    @PostMapping("/zlecenie")
    public void addZlecenie(@RequestBody Zlecenie zlecenie) {
        zlecenieService.addZlecenie(zlecenie);
    }

    @GetMapping("/zlecenie/{id_user}")
    public List<Zlecenie> getZleceniaWithId(@PathVariable Long id_user,
                                            @RequestParam(required = false) Integer page,
                                            Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return zlecenieService.getZleceniaWithId(id_user, pageNumber, sortDirection);
    }
}