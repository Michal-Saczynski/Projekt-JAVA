package com.aaa.projekt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@Table(name="produkty")
public class Produkty {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long ID_produktu;
        private String nazwa;
        private double cena;
        private String plik;

        @ManyToMany(fetch = FetchType.LAZY,
                cascade = {
                        CascadeType.PERSIST,
                        CascadeType.MERGE
                },
                mappedBy = "produkty")
        @JsonIgnore
        private Set<Zamowienia> zamowienia = new HashSet<>();
    }

