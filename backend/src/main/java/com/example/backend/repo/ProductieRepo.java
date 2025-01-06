package com.example.backend.repo;

import com.example.backend.domain.Productie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;




public interface ProductieRepo extends JpaRepository<Productie, Long> {
    Optional<Productie> findProductieByIdProductie(Long id);

}

