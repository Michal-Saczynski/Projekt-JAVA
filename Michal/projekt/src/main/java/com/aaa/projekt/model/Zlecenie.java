package com.aaa.projekt.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "zlecenie")
public class Zlecenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_user", updatable = false)
    private Users users;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_produktu", updatable = false)
    private Produkty produkty;
}
