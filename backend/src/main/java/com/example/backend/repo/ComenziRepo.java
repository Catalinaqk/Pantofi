package com.example.backend.repo;

import com.example.backend.domain.Comenzi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for managing Comenzi entities.
 */
public interface ComenziRepo extends JpaRepository<Comenzi, String> {

    /**
     * Finds a comenzi by its unique identifier.
     *
     * @param id the unique identifier of the comenzi.
     * @return an Optional containing the found comenzi, or empty if no comenzi is found.
     */
    Optional<Comenzi> findComenziById(String id);

    /**
     * Finds a comenzi by its name.
     *
     * @param nume the name of the comenzi.
     * @return an Optional containing the found comenzi, or empty if no comenzi is found.
     */
    Optional<Comenzi> findComenziByNume(String nume);
}