package com.example.projcolloquio.converter;

import com.example.projcolloquio.data.dto.UserDTO;
import com.example.projcolloquio.data.entity.Utente;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

    public UserDTO convertUserToDto(Utente user){
        UserDTO dto=new UserDTO();
        dto.setNome(user.getNome());
        dto.setCognome(user.getCognome());
        dto.setEmail(user.getEmail());
        return dto;
    }

}
