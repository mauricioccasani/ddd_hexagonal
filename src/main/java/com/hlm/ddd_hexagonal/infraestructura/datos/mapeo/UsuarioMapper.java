package com.hlm.ddd_hexagonal.infraestructura.datos.mapeo;

import com.hlm.ddd_hexagonal.dominio.entidades.UserDTO;
import com.hlm.ddd_hexagonal.infraestructura.datos.entidades.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mappings({
            @Mapping(source = "idusuario", target = "idusuario"),
            @Mapping(source = "nombre", target = "nomusuario"),
            @Mapping(source = "correo", target = "email"),
            @Mapping(source = "contrasenia", target = "password"),
            @Mapping(source = "direccion", target = "direccion"),
            @Mapping(source = "telefono", target = "telefono"),
            @Mapping(source = "empresa", target = "empresa"),
            @Mapping(source = "ruc", target = "ruc"),
            @Mapping(source = "tipo", target = "tipo"),
            @Mapping(source = "fecha", target = "fecha")
    })
    UserDTO toUser(Usuario usuario);
    List<UserDTO> toUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration
    Usuario toUsuario(UserDTO user);

}
