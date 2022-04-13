package com.example.projcolloquio.data.entity;

import lombok.Data;

import javax.persistence.*;

@Data @Table(name = "utenti") @Entity
public class Utente {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "cognome")
    private String cognome;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
}
