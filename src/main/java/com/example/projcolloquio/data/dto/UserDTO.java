package com.example.projcolloquio.data.dto;

import lombok.Data;

@Data
public class UserDTO {
    private long id;
    private String nome;
    private String cognome;
    private String email;
}
