package com.example.backend.repo;

import com.example.backend.domain.Materiale;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

/**
 * Repository interface for managing Materiale entities.
 */


public interface MaterialeRepo extends JpaRepository<Materiale, String> {

    /**
     * Finds a materiale by its unique identifier.
     *
     * @param id the unique identifier of the materiale.
     * @return an Optional containing the found materiale, or empty if no materiale is found.
     */
    Optional<Materiale> findMaterialeById(String id);

    /**
     * Finds a materiale by its name.
     *
     * @param name the name of the materiale.
     * @return an Optional containing the found materiale, or empty if no materiale is found.
     */
    Optional<Materiale> findMaterialeByName(String name);
}
