package com.hlm.ddd_hexagonal.infraestructura.datos.servicios.clientes.rest.interfaces;

import com.hlm.ddd_hexagonal.infraestructura.datos.servicios.clientes.rest.dto.UsuarioDto;
import com.hlm.ddd_hexagonal.infraestructura.datos.servicios.clientes.rest.dto.UsuarioRequest;
import com.hlm.ddd_hexagonal.infraestructura.datos.servicios.clientes.rest.service.ExecptionError;

import java.util.List;

public interface UsuarioServiceInf {

    public List<UsuarioDto>listar();

    public List<UsuarioDto>buscarXnombre(UsuarioRequest request)throws ExecptionError;
    public List<UsuarioDto>buscarXCorreo(String correo);
}
