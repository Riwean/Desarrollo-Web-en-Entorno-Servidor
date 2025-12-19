package com.pruebas.bdd1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Episodios")
public class Episodios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "episodio_id")
    private int episodioId;

    @Column(name = "serie_id")
    private int serieId;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "duracion")
    private int duracion;

    @Column(name = "rating_imdb")
    private int ratingImdb;

    @Column(name = "temporada")
    private int temporada;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_estreno")
    private java.sql.Date fechaEstreno;
}
