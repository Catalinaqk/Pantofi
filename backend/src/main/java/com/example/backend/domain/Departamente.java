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
@Table(name = "departamente")

public class Departamente {

    /**
     * Unique identifier for the departamente.
     */
    @Id
    @UuidGenerator
    @Column(name = "id", unique = true, updatable = false)
    private String id;

    /**
     * Name of the departamente.
     */
    private String name;

    /**
     * Description of the departamente.
     */
    private String description;

    /**
     * Responsible of the departamente.
     */
    private String responsible;

    /**
     * Password of the departamente.
     */
    private String password;
}
