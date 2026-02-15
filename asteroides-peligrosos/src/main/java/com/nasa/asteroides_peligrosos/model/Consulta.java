package com.nasa.asteroides_peligrosos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "consultas")
@Data
@NoArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Fecha consultada por el usuario
    @Column(nullable = false)
    private LocalDate fechaConsultada;

    // Número de asteroides peligrosos encontrados
    @Column(nullable = false)
    private Integer numeroAsteroidesPeligrosos;

    // Fecha y hora en que se realizó la consulta
    @Column(nullable = false)
    private LocalDateTime fechaHoraConsulta;

    // Usuario que realizó la consulta
    private String usuario;

    // Constructor
    public Consulta(LocalDate fechaConsultada, Integer numeroAsteroidesPeligrosos, String usuario) {
        this.fechaConsultada = fechaConsultada;
        this.numeroAsteroidesPeligrosos = numeroAsteroidesPeligrosos;
        this.fechaHoraConsulta = LocalDateTime.now();
        this.usuario = usuario;
    }
}
