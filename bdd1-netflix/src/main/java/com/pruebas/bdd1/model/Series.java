package com.pruebas.bdd1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serie_id")
    private int serieId;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "año_lanzamiento")
    private int añoLanzamiento;

    @Column(name = "genero")
    private String genero;
}