package com.example.backend.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Entity class representing a Materiale (Materials).
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT) // exclude null fields
@Table(name = "materiale")
public class Materiale {

    /**
     * Unique identifier for the material record.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMateriale", unique = true, updatable = false, nullable = false)
    private Long id;

    /**
     * Name of the material.
     */
    @Column(name = "nume", nullable = false)
    private String nume;

    /**
     * Type of the material.
     */
    @Column(name = "tip", nullable = false)
    private String tip;

    /**
     * Status of the material.
     */
    @Column(name = "status", nullable = false)
    private String status;

    /**
     * Price of the material.
     */
    @Column(name = "cost", nullable = false)
    private double cost;

    /**
     * Quantity of the material.
     */
    @Column(name = "cantitate", nullable = false)
    private int cantitate;

    /**
     * Date of the material.
     */
    @Column(name = "data", nullable = false)
    private LocalDate data;

    /**
     * Description of the material.
     */
    @Column(name = "descriere", nullable = false)
    private String descriere;
}