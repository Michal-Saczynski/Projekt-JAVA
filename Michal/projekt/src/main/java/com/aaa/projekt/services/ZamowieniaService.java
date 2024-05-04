package com.aaa.projekt.services;

import com.aaa.projekt.Repository.ZamowieniaRepository;
import com.aaa.projekt.model.Zamowienia;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZamowieniaService {

        private static final int PAGE_SIZE = 3;
        private final ZamowieniaRepository zamowieniaRepository;

        public List<Zamowienia> getZamowienia(int page) {
            return zamowieniaRepository.findAllZamowienia(
                    PageRequest.of(page, PAGE_SIZE)
            );
        }

        public Zamowienia getSingleZamowienie(long id) {
            Zamowienia zamowienia = zamowieniaRepository.findById(id)
                    .orElseThrow();

            return new ResponseEntity<>(zamowienia, HttpStatus.OK).getBody();
        }

        public Zamowienia addZamowienie(Zamowienia zamowienia) {
            return zamowieniaRepository.save(zamowienia);
        }

        public void deleteSingleZamowienia(long id) {
            zamowieniaRepository.deleteById(id);
        }

        public Zamowienia addZamowieniaDWA(Zamowienia zamowienia) {
            return zamowieniaRepository.save(zamowienia);
        }

    }

