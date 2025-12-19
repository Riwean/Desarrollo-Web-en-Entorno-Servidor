package com.pruebas.bdd1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Actores")
public class Actores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private int actorId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_nacimiento")
    private java.sql.Date fechaNacimiento;
}
