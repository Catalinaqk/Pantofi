package com.example.backend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Entity class representing a Productie (Production).
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT) // exclude null fields
@Table(name = "productie")
public class Productie {

    /**
     * Unique identifier for the production record.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProductie", unique = true, updatable = false, nullable = false)
    private Long id;

    /**
     * Name of the worker.
     */
    @Column(name = "numeLucrator", nullable = false)
    private String numeLucrator;

    /**
     * Quantity of the product.
     */
    @Column(name = "cantitateProdusa", nullable = false)
    private int cantitateProdusa;

    /**
     * Identifier of the associated material.
     */
    @ManyToOne
    @JoinColumn(name = "idMateriale", referencedColumnName = "idMateriale")
    @JsonBackReference
    private Materiale materiale;

    /**
     * Date of the production.
     */
    @Column(name = "data", nullable = false)
    private LocalDate date;
}