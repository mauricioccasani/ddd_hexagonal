package com.hlm.ddd_hexagonal.aplicacion.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Taller {
    @NotEmpty(message = "REQUERIDO")
    @NotNull
    @NotBlank
    private String nombre;
    @NotBlank
    @NotEmpty
    private String instructor;
}
