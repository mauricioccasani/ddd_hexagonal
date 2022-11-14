package com.hlm.ddd_hexagonal.dominio.servicios;

import com.hlm.ddd_hexagonal.dominio.entidades.UserDTO;
import com.hlm.ddd_hexagonal.dominio.interfaces.IUserService;
import com.hlm.ddd_hexagonal.infraestructura.datos.repositorios.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Log4j2
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Cacheable(value = "usuarios",key = "#root.method.name")
    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> response=null;
        Long inicio= System.currentTimeMillis();
        log.info("Tiempo de inicio: {}",inicio);
        try {
            response=  userRepository.getAll();
        }catch (Exception e){
            log.info("ERROR: {}",e.getMessage());
        }finally {
            log.info("Tiempo de evocacion: {}",System.currentTimeMillis()-inicio);
        }



        return userRepository.getAll();

    }

    @Override
    public Optional<UserDTO> getUser(int idusuario) {
        return userRepository.getUser(idusuario);
    }

    @Override
    public UserDTO save(UserDTO user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(int idusuario) {

        return getUser(idusuario)
                .map(usuario -> {
                    userRepository.delete(idusuario);
                    return true;
                }).orElse(false);
    }

    @Override
    public List<UserDTO> findByNombre(String nombre) {
        return this.userRepository.findByNombre(nombre);
    }

    @Override
    public List<UserDTO> findByCorreo(String correo) {
        return this.userRepository.findByCorreo(correo);
    }

}
