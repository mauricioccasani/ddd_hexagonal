package com.hlm.ddd_hexagonal.dominio.entidades;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseError {
    private String codigo;
    private String mesaje;

}
