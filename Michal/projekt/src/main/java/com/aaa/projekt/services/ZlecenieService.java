package com.aaa.projekt.services;

import com.aaa.projekt.Repository.ZamowieniaRepository;
import com.aaa.projekt.Repository.ZlecenieRepository;
import com.aaa.projekt.model.Uzytkownicy;
import com.aaa.projekt.model.Zlecenie;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ZlecenieService {
    private final ZlecenieRepository zlecenieRepository;
    private static final int PAGE_SIZE = 10;
    public Zlecenie addZlecenie(Zlecenie zlecenie) {
        return zlecenieRepository.save(zlecenie);
    }

    public List<Zlecenie> getZleceniaWithId(Long id_user, int page, Sort.Direction sort) {
        PageRequest pageRequest = PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id"));
        return zlecenieRepository.findAllZleceniaByUserId(id_user, pageRequest);
    }
}
