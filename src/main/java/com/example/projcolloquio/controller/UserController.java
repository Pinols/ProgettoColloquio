package com.example.projcolloquio.controller;

import com.example.projcolloquio.data.dto.UserDTO;
import com.example.projcolloquio.data.entity.Utente;
import com.example.projcolloquio.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping(value = "/register")
    public String registerUser(@RequestBody Utente user) {
        return userService.registerUser(user);
       // return userService.getAllUsers();
    }

    @GetMapping(value = "/get-users")
    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/get-user")
    public Utente getUser(@RequestParam long id) {
        return userService.getUser(id);
    }

    @PostMapping(value="/edit-user")
    public String editUser(@RequestBody Utente user){
        return userService.editUser(user);
    }

    @GetMapping(value = "/search")
    public List<Utente> searchUser(@RequestParam String searchText){
        return userService.searchUser(searchText);
    }
}
