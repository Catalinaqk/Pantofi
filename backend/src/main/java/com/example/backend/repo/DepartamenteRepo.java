package com.example.backend.repo;

import com.example.backend.domain.Departamente;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface DepartamenteRepo extends JpaRepository<Departamente, Long>
{
    /**
     * Finds a department by its unique identifier.
     *
     * @param id the unique identifier of the department.
     * @return an Optional containing the found department, or empty if no department is found.
     */
    Optional<Departamente> findDepartamenteById(String id);

    /**
     * Finds a department by its name.
     *
     * @param name the name of the department.
     * @return an Optional containing the found department, or empty if no department is found.
     */
    Optional<Departamente> findDepartamenteByName(String name);





}
