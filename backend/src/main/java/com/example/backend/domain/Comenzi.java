package com.example.backend.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT) // exclude null fields
@Table(name = "comenzi_produse")

public class Comenzi {

        /**
         * Unique identifier for the comenzi.
         */
        @Id
        @UuidGenerator
        @Column(name = "id", unique = true, updatable = false)
        private String id;

        /**
         * Unique identifier for the material.
         */
        private String materialId;

        /**
         * Unique identifier for the departament .
         */
        private String departamenteId;

        /**
         * Quantity of the produse.
         */
        private String quantity;

        /**
         * Status of the comenzi (e.g., pending, completed).
         */
        private String status;

        /**
         * Date of the comenzi.
         */
        private String date;

        /**
         * Total price of the comenzi.
         */
        private String totalPrice;

        /**
         * Address of the comenzi.
         */
        private String address;


}
