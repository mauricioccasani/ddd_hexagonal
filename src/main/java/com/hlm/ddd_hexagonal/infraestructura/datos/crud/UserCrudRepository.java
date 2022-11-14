package com.hlm.ddd_hexagonal.infraestructura.datos.crud;

import com.hlm.ddd_hexagonal.infraestructura.datos.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCrudRepository  extends CrudRepository<Usuario, Integer> {

    public List<Usuario>findByNombre(String nombre);

    public List<Usuario>findByCorreo(String correo);
}
