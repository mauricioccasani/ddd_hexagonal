package com.hlm.ddd_hexagonal.aplicacion.rest;

import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;
@Data
public class RequestTaller {

    @Size(min = 2,max = 2)
    private List<Taller> tallers;
}
