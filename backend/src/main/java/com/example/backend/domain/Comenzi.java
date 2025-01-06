package com.example.backend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

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
         * Unique identifier for the order.
         */
        @Id
        @UuidGenerator
        @Column(name = "id", unique = true, updatable = false)
        private String id;

        /**
         * Name of the order.
         */
        private String nume;

        /**
         * Status of the order.
         */
        private String status;

        /**
         * Price of the order.
         */
        private String cost;

        /**
         * Quantity of the order.
         */
        private String cantitate;

        /**
         * Date of the order.
         */
        private String data;

        /**
         * Description of the order.
         */
        private String descriere;


}