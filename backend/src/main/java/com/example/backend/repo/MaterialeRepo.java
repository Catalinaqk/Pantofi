package com.example.backend.repo;

import com.example.backend.domain.Materiale;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface MaterialeRepo extends JpaRepository<Materiale, Long> {
    Optional<Materiale> findByName(String name);
}
