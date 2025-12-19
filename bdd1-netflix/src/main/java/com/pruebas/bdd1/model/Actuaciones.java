package com.pruebas.bdd1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Actuaciones")
public class Actuaciones {
    //LA CLAVE PRIMARIA ES COMPUESTA
    @Id
    @Column(name = "actor_id")
    private int actorId;

    @Id
    @Column(name = "serie_id")
    private int serieId;

    @Column(name = "personaje")
    private String personaje;
}
