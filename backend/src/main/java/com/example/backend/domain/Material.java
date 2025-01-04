package com.example.backend.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT) // exclude null fields
@Table(name = "material")

public class Material {

    /**
     * Unique identifier for the material.
     */
    @Id
    @UuidGenerator
    @Column(name = "id", unique = true, updatable = false)
    private String id;

    /**
     * Name of the material.
     */
    private String name;

    /**
     * Description of the material.
     */
    private String description;

    /**
     * Type of the material.
     */
    private String type;

    /**
     * Status of the material.
     */
    private String status;

    /**
     * Quantity of the material.
     */
    private String quantity;

    /**
     * Price of the material.
     */
    private String price;

    /**
     * Date of the material.
     */
    private String date;


    /**
     * URL of the material's cover image.
     */
    private String photoURL;
}
