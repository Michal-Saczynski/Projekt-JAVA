package com.aaa.projekt.model;

import javax.persistence.*;


@Entity
@Table(name = "role")
public class Role {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID_roli")
        private int id;

        @Column(name = "Nazwa")
        private String name;


    }


