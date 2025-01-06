package com.example.backend.repo;

import com.example.backend.domain.Comenzi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;


/**
 * Repository interface for managing Comenzi entities.
 */
@Repository
public interface ComenziRepo extends JpaRepository<Comenzi, Long> {

    /**
     * Finds a comenzi by its unique identifier.
     *
     * @param id the unique identifier of the comenzi.
     * @return an Optional containing the found comenzi, or empty if no comenzi is found.
     */
    Optional<Comenzi> findComenziById(Long id);

    /**
     * Finds a comenzi by its name.
     *
     * @param name the name of the comenzi.
     * @return an Optional containing the found comenzi, or empty if no comenzi is found.
     */
    Optional<Comenzi> findComenziByName(String name);


}