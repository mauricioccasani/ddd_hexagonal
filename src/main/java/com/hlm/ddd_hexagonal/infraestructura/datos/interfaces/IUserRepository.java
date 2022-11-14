package com.hlm.ddd_hexagonal.infraestructura.datos.interfaces;

import com.hlm.ddd_hexagonal.dominio.entidades.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    public List<UserDTO> getAll();

    public Optional<UserDTO> getUser(int idusuario);

    public UserDTO save(UserDTO user);

    public void delete(int idusuario);

    public List<UserDTO>findByNombre(String nombre);
    public List<UserDTO>findByCorreo(String correo);

}
