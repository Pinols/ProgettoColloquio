package com.example.projcolloquio.service;

import com.example.projcolloquio.data.dto.UserDTO;
import com.example.projcolloquio.data.entity.Utente;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    String registerUser(Utente user);

    String editUser(Utente user);

    List<Utente> searchUser(String searchText);

    Utente getUser(long id);

    String editName(long id, String name);

    String deleteUser(long id);
}
