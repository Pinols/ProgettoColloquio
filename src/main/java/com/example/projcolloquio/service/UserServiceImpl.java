package com.example.projcolloquio.service;

import com.example.projcolloquio.converter.UserConverter;
import com.example.projcolloquio.data.dto.UserDTO;
import com.example.projcolloquio.data.entity.Utente;
import com.example.projcolloquio.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter converter;
    public UserServiceImpl(UserRepository userRepo, UserConverter converter){
        this.userRepository = userRepo;
        this.converter = converter;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        try{
            List<Utente> allUsers=userRepository.findAll();
            List<UserDTO> dtos=new ArrayList<>();
            for(Utente u:allUsers){
                dtos.add(converter.convertUserToDto(u));
            }
            return dtos;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String registerUser(Utente user) {
        try{
            user=createFullText(user);
            userRepository.save(user);
            return "Utente "+user.getNome()+" "+user.getCognome()+" registrato.";
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String editUser(Utente user){
        try{
            Utente old=userRepository.findById(user.getId()).orElseThrow(() -> new Exception("Utente non trovato."));
            old.setNome(user.getNome());
            old.setCognome(user.getCognome());
            old.setEmail(user.getEmail());
            //
            // sto ignorando qualunque forma di security per la password semplicemente perchè non richiesto
            //
            old.setPassword(user.getPassword());
            old=createFullText(old);
            userRepository.save(old);
            return "Utente modificato con successo.";
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Utente> searchUser(String searchText) {
        try{
            return userRepository.searchUtente(searchText);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Utente getUser(long id) {
        try{
            return userRepository.findById(id).orElseThrow(() -> new Exception("Utente non trovato"));
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Utente createFullText(Utente user){
        String sb = user.getNome() +
                " " +
                user.getCognome() +
                " " +
                user.getEmail();
        user.setFullText(sb.toLowerCase(Locale.ROOT));
        return user;
    }
}
