package com.example.projcolloquio.repository;

import com.example.projcolloquio.data.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Utente,Long> {

    @Query(value = "select u from Utente u where u.fullText like %?1% order by u.id")
    List<Utente> searchUtente(String search);
}
