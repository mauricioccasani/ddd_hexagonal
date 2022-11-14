package com.hlm.ddd_hexagonal.dominio.interfaces;

import com.hlm.ddd_hexagonal.dominio.entidades.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<UserDTO> getAll();
    public Optional<UserDTO> getUser(int idusuario);
    public UserDTO save(UserDTO user);
    public boolean delete(int idusuario);
    public List<UserDTO> findByNombre(String nombre);
    public List<UserDTO> findByCorreo(String correo);

}
