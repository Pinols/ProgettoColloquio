package com.example.projcolloquio.data.entity;

import lombok.Data;

import javax.persistence.Table;

@Data @Table(name = "user")
public class User {

    private long id;

    private String nome;
    private String cognome;
    private String email;
    private String password;
}
