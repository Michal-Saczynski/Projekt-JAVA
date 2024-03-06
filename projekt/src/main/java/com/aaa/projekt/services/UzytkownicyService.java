package com.aaa.projekt.services;

import com.aaa.projekt.Repository.UzytkownicyRepository;
import com.aaa.projekt.Repository.ZamowieniaRepository;
import com.aaa.projekt.model.Uzytkownicy;
import com.aaa.projekt.model.Zamowienia;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UzytkownicyService {
    private static final int PAGE_SIZE = 3;
    private final UzytkownicyRepository uzytkownicyRepository;

    public List<Uzytkownicy> getUzytkownicy(int page) {
        return uzytkownicyRepository.findAllUzytkownicy(
                PageRequest.of(page, PAGE_SIZE)
        );
    }

    public Uzytkownicy getSingleUzytkownicy(long id) {
        Uzytkownicy uzytkownicy = uzytkownicyRepository.findById(id)
                .orElseThrow();

        return new ResponseEntity<>(uzytkownicy, HttpStatus.OK).getBody();
    }

    public Uzytkownicy adduzytkownicy(Uzytkownicy uzytkownicy) {
        return uzytkownicyRepository.save(uzytkownicy);
    }

    public void deleteSingleUzytkownicy(long id) {
        uzytkownicyRepository.deleteById(id);
    }
}

