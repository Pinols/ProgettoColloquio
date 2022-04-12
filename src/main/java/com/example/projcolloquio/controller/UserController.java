package com.example.projcolloquio.controller;

import com.example.projcolloquio.data.dto.UserDTO;
import com.example.projcolloquio.data.entity.User;
import com.example.projcolloquio.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/api/v1/user")
public class UserController {

    private UserService userService;
    public UserController(UserService userService){
    }

    @GetMapping(value = "/register")
    public List<UserDTO> registerUser(@RequestBody User user){
        return userService.getAllUsers();
    }
}
