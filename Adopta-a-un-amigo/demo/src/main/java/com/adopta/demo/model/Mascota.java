package com.adopta.demo.model;

import jakarta.validation.constraints.*;

public class Mascota {

    //Atributos
    private Long id;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotNull(message = "La edad es obligatoria")
    @Min(value=0, message = "La edad debe ser positiva")
    @Max(value = 30, message = "La edad es demasiado alta")
    private Integer edad;
    private boolean adoptado;
    @Pattern(regexp = "perro|gato|otro", message = "La especie debe ser: perro, gato u otro")
    @NotBlank(message = "La especie es obligatoria")
    private String especie;
    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    private String descripcion;

    //Constructores

    public Mascota(Long id, String nombre, Integer edad, boolean adoptado, String especie, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.adoptado = adoptado;
        this.especie = especie;
        this.descripcion = descripcion;
    }

    public Mascota() {
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public boolean isAdoptado() {
        return adoptado;
    }

    public Long getId() {
        return id;
    }

    public String getEspecie() {
        return especie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
