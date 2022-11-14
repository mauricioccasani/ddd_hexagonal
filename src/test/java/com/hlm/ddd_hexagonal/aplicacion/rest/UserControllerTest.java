package com.hlm.ddd_hexagonal.aplicacion.rest;

import com.hlm.ddd_hexagonal.dominio.entidades.UserDTO;
import com.hlm.ddd_hexagonal.dominio.servicios.UserService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@Log4j2
@WebMvcTest(UserController.class)
class UserControllerTest {
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;
    @Test
    void save() throws Exception {
        int id=1;
       Optional<UserDTO> userDTO=Optional.of(UserControllerTest.dto());
       log.info("Data: {}",userDTO);
        given(this.userService.getUser(1))
                .willReturn(userDTO);
        this.mockMvc.perform(post(""));
       // this.mockMvc.perform(get("/api/users/{id}",id).accept(MediaType.APPLICATION_JSON))
         //      .andExpect(status().isOk()).andExpect(content().string("Mauricio"));

    }

    private static UserDTO dto(){
        UserDTO usuario=new UserDTO();
        usuario.setIdusuario(1);
        usuario.setNomusuario("Jose");
        usuario.setPassword("1234");
        usuario.setEmail("j@email.com");
        usuario.setDireccion("chorrillos");
        usuario.setEmpresa("nttdata");
        usuario.setFecha(null);
        usuario.setTelefono("123456789");
        usuario.setRuc(123456);
        usuario.setTipo(1);
        return usuario;
    }

}