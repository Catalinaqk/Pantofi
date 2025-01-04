package com.example.backend.repo;

import com.example.backend.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaterialRepo extends JpaRepository<Material, Long>
{
    /**
     * Finds a material by its unique identifier.
     *
     * @param id the unique identifier of the material.
     * @return an Optional containing the found material, or empty if no material is found.
     */
    Optional<Material> findMaterialById(String id);

    /**
     * Finds a material by its name.
     *
     * @param name the name of the material.
     * @return an Optional containing the found material, or empty if no material is found.
     */
    Optional<Material> findMaterialByName(String name);


}
