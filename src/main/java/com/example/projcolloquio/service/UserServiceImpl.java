package com.example.projcolloquio.service;

import com.example.projcolloquio.converter.UserConverter;
import com.example.projcolloquio.data.dto.UserDTO;
import com.example.projcolloquio.data.entity.User;
import com.example.projcolloquio.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserConverter converter;
    public UserServiceImpl(UserRepository userRepo, UserConverter converter){
        this.userRepository = userRepo;
        this.converter = converter;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        try{
            List<User> allUsers=userRepository.findAll();
            List<UserDTO> dtos=new ArrayList<>();
            for(User u:allUsers){
                dtos.add(converter.convertUserToDto(u));
            }
            return dtos;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
