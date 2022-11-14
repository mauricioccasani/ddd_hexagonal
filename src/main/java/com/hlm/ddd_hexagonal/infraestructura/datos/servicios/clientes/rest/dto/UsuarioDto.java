package com.hlm.ddd_hexagonal.infraestructura.datos.servicios.clientes.rest.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class UsuarioDto implements Serializable {
    private int idusuario;
    private String nomusuario;
    private String email;
    private String password;
    private String direccion;
    private String telefono;
    private String empresa;
    private int ruc;
    private int tipo;
    private LocalDate fecha;

}
