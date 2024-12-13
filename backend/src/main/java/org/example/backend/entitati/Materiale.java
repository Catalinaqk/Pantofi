package org.example.backend.entitati;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "materiale")
public class Materiale {
    @Id
    @UuidGenerator
    @Column(name = "id",unique = true, updatable = false)
    private String id_materiale;
    private String denumire;
    private String tip;
    private String cantitatedisponibila;
    private String unitatemasura;
    private String pretunitar;
    private String dataachizitie;
    private String descriere;
}
