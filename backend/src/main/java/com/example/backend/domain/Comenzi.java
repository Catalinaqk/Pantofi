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
 * Entity class representing a Comenzi (Orders).
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT) // exclude null fields
@Table(name = "comenzi")
public class Comenzi {

        /**
         * Unique identifier for the order record.
         */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "idComanda", unique = true, updatable = false, nullable = false)
        private Long idComanda;

        /**
         * Name of the order.
         */
        @Column(name = "nume", nullable = false)
        private String nume;

        /**
         * Status of the order.
         */
        @Column(name = "status", nullable = false)
        private String status;

        /**
         * Price of the order.
         */
        @Column(name = "cost", nullable = false)
        private double cost;

        /**
         * Quantity of the order.
         */
        @Column(name = "cantitate", nullable = false)
        private int cantitate;

        /**
         * Date of the order.
         */
        @Column(name = "data", nullable = false)
        private LocalDate data;

        /**
         * Description of the order.
         */
        @Column(name = "descriere", nullable = false)
        private String descriere;

        /**
         * Identifier of the associated material.
         */
        @ManyToOne
        @JoinColumn(name = "idMateriale", referencedColumnName = "idMateriale")
        @JsonBackReference
        private Materiale materiale;


}