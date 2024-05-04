package com.aaa.projekt.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "uzytkownicy")
public class Uzytkownicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_uzytkownika")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private int phone;


    @Column(name = "email")
    private String email;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_roli", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore

    private Role role;

}


