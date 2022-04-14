package com.example.projcolloquio.service;

import com.example.projcolloquio.data.entity.Utente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    //
    // Data la stretta relazione fra registrazione e recupero degli utenti,
    // ho preferito testare entrambe le cose contemporaneamente
    //
    @Test
    void registerAndGetUserTest(@Autowired UserService userService) {
        Utente user = new Utente(1L,"john","travolta","johntravolta@gmail.com","johntravolta");
        userService.registerUser(user);

        Utente found=userService.getUser(1L);
        assertEquals(user.getCognome(),found.getCognome());
        assertEquals(user.getNome(),found.getNome());
        assertEquals(user.getEmail(),found.getEmail());
        assertEquals(user.getPassword(),found.getPassword());
        assertEquals("john travolta johntravolta@gmail.com",found.getFullText());
    }

    @Test
    void searchUtenteTest(@Autowired UserService userService){
        userService.registerUser(new Utente(2L,"carlo","rossi","carlorossi@gmail.com",
                "carlorossi"));

        userService.registerUser(new Utente(3L,"antonio","bianchi","antoniobianchi@gmail.com",
                "antoniobianchi"));

        List<Utente> matches=userService.searchUser("car");

        for(Utente u:matches){
            assert u.getFullText().contains("car");
        }
    }
}
