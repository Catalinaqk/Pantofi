package com.example.backend.repo;

import com.example.backend.domain.Comenzi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComenziRepo extends JpaRepository<Comenzi, Long>
{
    /**
     * Finds a order by its unique identifier.
     *
     * @param id the unique identifier of the order.
     * @return an Optional containing the found order, or empty if no order is found.
     */
    Optional<Comenzi> findComenziById(String id);

    /**
     * Finds a order by its name.
     *
     * @param name the name of the order.
     * @return an Optional containing the found order, or empty if no order is found.
     */
    Optional<Comenzi> findComenziByName(String name);

    /**
     * Finds a order by its name.
     *
     * @param name the name of the order.
     * @return an Optional containing the found order, or empty if no order is found.
     */
    Optional<Comenzi> findComenziByStatus(String name);

    /**
     * Finds a order by its name.
     *
     * @param name the name of the order.
     * @return an Optional containing the found order, or empty if no order is found.
     */
    Optional<Comenzi> findComenziByData(String name);

    /**
     * Finds a order by its name.
     *
     * @param name the name of the order.
     * @return an Optional containing the found order, or empty if no order is found.
     */
    Optional<Comenzi> findComenziByDepartament(String name);

    /**
     * Finds a order by its name.
     *
     * @param name the name of the order.
     * @return an Optional containing the found order, or empty if no order is found.
     */
    Optional<Comenzi> findComenziByMaterial(String name);

    /**
     * Finds a order by its name.
     *
     * @param name the name of the order.
     * @return an Optional containing the found order, or empty if no order is found.
     */
    Optional<Comenzi> findComenziByCantitate(String name);

    /**
     * Finds a order by its name.
     *
     * @param name the name of the order.
     * @return an Optional containing the found order, or empty if no order is found.
     */
    Optional<Comenzi> findComenziByPret(String name);



}
