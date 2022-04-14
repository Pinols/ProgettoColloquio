package com.example.projcolloquio.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data @Table(name = "utenti") @Entity
@AllArgsConstructor @NoArgsConstructor
public class Utente {

    public Utente(Long id,String nome,String cognome,String email,String password){
        this.id=id;
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.password=password;
    }

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
    @Column(name="fulltext")
    private String fullText;
}
