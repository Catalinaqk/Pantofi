package com.example.backend.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

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
     * Unique identifier for the material.
     */
    @Id
    @UuidGenerator
    @Column(name = "id", unique = true, updatable = false)
    private String id;

    /**
     * Name of the material.
     */
    private String nume;

    /**
     * Type of the material.
     */
    private String tip;

    /**
     * Status of the material.
     */
    private String status;

    /**
     * Description of the material.
     */
    private String descriere;

    /**
     * URL of the material's photo.
     */
    private String photoURL;
}