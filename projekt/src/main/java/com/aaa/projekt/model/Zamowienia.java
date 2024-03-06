package com.aaa.projekt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="Zamowienia")
public class Zamowienia {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID_zamowienia;
    private int ilosc;
    private Date data;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "zamowieniaprodukty",
            joinColumns = { @JoinColumn(name = "zamowienia_id") },
            inverseJoinColumns = { @JoinColumn(name = "produkty_id") })
    private Set<Produkty> produkty = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_uzytkownika", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Uzytkownicy uzytkownicy;
}
