package com.hlm.ddd_hexagonal.infraestructura.datos.repositorios;

import com.hlm.ddd_hexagonal.dominio.entidades.UserDTO;
import com.hlm.ddd_hexagonal.infraestructura.datos.crud.UserCrudRepository;
import com.hlm.ddd_hexagonal.infraestructura.datos.entidades.*;
import com.hlm.ddd_hexagonal.infraestructura.datos.interfaces.IUserRepository;
import com.hlm.ddd_hexagonal.infraestructura.datos.mapeo.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public List<UserDTO> getAll() {
        List<Usuario> usuarios = (List<Usuario>) userCrudRepository.findAll();
        return usuarioMapper.toUsers(usuarios);
    }


    @Override
    public Optional<UserDTO> getUser(int userId) {
        return userCrudRepository.findById(userId)
                .map(usuario -> usuarioMapper.toUser(usuario));
    }

    @Override
    public UserDTO save(UserDTO user) {
        Usuario usuario = usuarioMapper.toUsuario(user);
        return usuarioMapper.toUser(userCrudRepository.save(usuario));
    }

    @Override
    public void delete(int userId) {
        userCrudRepository.deleteById(userId);
    }

    @Override
    public List<UserDTO> findByNombre(String nombre) {
        List<Usuario> usuarios = (List<Usuario>) userCrudRepository.findByNombre(nombre);
        return usuarioMapper.toUsers(usuarios);
    }

    @Override
    public List<UserDTO> findByCorreo(String correo) {
        List<Usuario> usuarios = (List<Usuario>) userCrudRepository.findByCorreo(correo);
        return usuarioMapper.toUsers(usuarios);
    }

}
