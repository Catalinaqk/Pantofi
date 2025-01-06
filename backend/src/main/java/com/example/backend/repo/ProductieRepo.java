package com.example.backend.repo;

import com.example.backend.domain.Productie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing Productie entities.
 */
@Repository
public interface ProductieRepo extends JpaRepository<Productie, String> {
    /**
     * Finds a productie by its unique identifier.
     *
     * @param id the unique identifier of the productie.
     * @return an Optional containing the found productie, or empty if no productie is found.
     */
    Optional<Productie> findProductieById(String id);

    /**
     * Finds a productie by its name.
     *
     * @param name the name of the productie.
     * @return an Optional containing the found productie, or empty if no productie is found.
     */
    Optional<Productie> findProductieByName(String name);

}

