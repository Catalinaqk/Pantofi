package com.example.backend.repo;

import com.example.backend.domain.Comenzi;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ComenziRepo extends JpaRepository<Comenzi, Long> {
    Optional<Comenzi> findComenziByProductie(String productie);
}