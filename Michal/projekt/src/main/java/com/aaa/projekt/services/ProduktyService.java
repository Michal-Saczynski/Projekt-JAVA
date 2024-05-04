package com.aaa.projekt.services;

import com.aaa.projekt.Repository.ProduktyRepository;
import com.aaa.projekt.model.Produkty;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProduktyService {
    private static final int PAGE_SIZE = 6;
    private final ProduktyRepository produktyRepository;

    public List<Produkty> getProdukty(int page) {
        return produktyRepository.findAllProdukty(
                PageRequest.of(page, PAGE_SIZE)
        );


    }
}
