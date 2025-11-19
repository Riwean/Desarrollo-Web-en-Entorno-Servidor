package com.adopta.demo.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
