package com.example.projcolloquio.repository;

import com.example.projcolloquio.data.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Utente,Long> {

}
