package com.hlm.ddd_hexagonal.aplicacion.rest;


import com.hlm.ddd_hexagonal.dominio.entidades.UserDTO;
import com.hlm.ddd_hexagonal.dominio.servicios.UserService;
import com.hlm.ddd_hexagonal.infraestructura.datos.ExeptionUtil;
import com.hlm.ddd_hexagonal.infraestructura.datos.servicios.clientes.rest.dto.UsuarioDto;
import com.hlm.ddd_hexagonal.infraestructura.datos.servicios.clientes.rest.dto.UsuarioRequest;
import com.hlm.ddd_hexagonal.infraestructura.datos.servicios.clientes.rest.interfaces.UsuarioServiceInf;
import com.hlm.ddd_hexagonal.infraestructura.datos.servicios.clientes.rest.service.ExecptionError;
import com.hlm.ddd_hexagonal.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {

     @Autowired
    private UserService userService;
     @Autowired
    private UsuarioServiceInf usuarioServiceInf;

    @GetMapping("/externo")
    public List<UsuarioDto>lst(){
        return this.usuarioServiceInf.listar();
    }

    @GetMapping("/externoXcorreo/{correo}")
    public List<UsuarioDto>lstCorreo(@PathVariable String correo) throws ExeptionUtil {
        Util.valid(correo);
        return this.usuarioServiceInf.buscarXCorreo(correo);
    }

    @PostMapping("/pornombre")
    public ResponseEntity<?> buscarNombre(@RequestBody UsuarioRequest request) throws Exception {

        if (request.getNombre()==null||request.getNombre().isBlank()){
            throw new ExecptionError();
        }
        return new ResponseEntity<>(usuarioServiceInf.buscarXnombre(request),HttpStatus.OK);
    }



    @PostMapping("/nombres")
    public ResponseEntity<List<UserDTO>> buscarXnombre(@RequestBody UsuarioRequest request){
        return new ResponseEntity<>(userService.findByNombre(request.getNombre()), HttpStatus.OK);
    }

    @GetMapping("/internoXcorreo/{correo}")
    public ResponseEntity<List<UserDTO>> getAllCorreo(@PathVariable String correo){
        return new ResponseEntity<>(userService.findByCorreo(correo), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int id){
        return userService.getUser(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/save")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO user){

        user.setFecha(LocalDate.now());
        return new ResponseEntity<UserDTO>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (userService.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
