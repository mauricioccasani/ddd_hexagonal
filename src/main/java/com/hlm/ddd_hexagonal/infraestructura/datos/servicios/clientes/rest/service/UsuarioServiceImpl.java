package com.hlm.ddd_hexagonal.infraestructura.datos.servicios.clientes.rest.service;

import com.hlm.ddd_hexagonal.infraestructura.datos.servicios.clientes.rest.dto.UsuarioDto;
import com.hlm.ddd_hexagonal.infraestructura.datos.servicios.clientes.rest.dto.UsuarioRequest;
import com.hlm.ddd_hexagonal.infraestructura.datos.servicios.clientes.rest.interfaces.UsuarioServiceInf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UsuarioServiceImpl implements UsuarioServiceInf {
    private static final Logger LOG= LoggerFactory.getLogger(UsuarioServiceImpl.class);
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<UsuarioDto> listar() {
        String url="http://localhost:8081/jobs/api/users/all";
        List<UsuarioDto>respuesta=new ArrayList<>();
        try {
            HttpHeaders httpHeaders=new HttpHeaders();
            List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
            acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
            httpHeaders.setAccept(acceptableMediaTypes);

            HttpEntity<?>request=new HttpEntity(httpHeaders);
           // RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<UsuarioDto[]>response=restTemplate
                    .exchange(url, HttpMethod.GET, request, UsuarioDto[].class);
            respuesta= Arrays.asList(response.getBody());
        }catch (Exception e){
            e.printStackTrace();
        }
        return respuesta;
    }

    @Override
    public List<UsuarioDto> buscarXnombre(UsuarioRequest usuarioRequest)throws ExecptionError {

            String url="http://localhost:8081/jobs/api/users/nombres";
            List<UsuarioDto>respuesta=new ArrayList<>();
            try {
                HttpHeaders httpHeaders=new HttpHeaders();
                List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
                acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
                httpHeaders.setAccept(acceptableMediaTypes);
                LOG.info("REQUEST {}",usuarioRequest);
                HttpEntity<?>request=new HttpEntity(usuarioRequest,httpHeaders);

               // RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<UsuarioDto[]>response=restTemplate.exchange(url, HttpMethod.POST, request, UsuarioDto[].class);
                respuesta= Arrays.asList(response.getBody());
                LOG.info("RESPUESTA {}",respuesta);
            }catch (Exception e){
                e.printStackTrace();
                throw new ExecptionError();
            }
            return respuesta;

    }

    @Override
    public List<UsuarioDto> buscarXCorreo(String correo) {

            String url="http://localhost:8081/jobs/api/users/internoXcorreo/{correo}";
            List<UsuarioDto>respuesta=new ArrayList<>();
            try {
                HttpHeaders httpHeaders=new HttpHeaders();
                List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
                acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
                httpHeaders.setAccept(acceptableMediaTypes);

                HttpEntity<?>request=new HttpEntity(httpHeaders);
                Map<String, Object>urlParam=new HashMap<>();
                urlParam.put("correo",correo);

                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<UsuarioDto[]>response=restTemplate
                        .exchange(url, HttpMethod.GET, request, UsuarioDto[].class,urlParam);
                respuesta= Arrays.asList(response.getBody());
            }catch (Exception e){
                e.printStackTrace();
            }
            return respuesta;

    }
}
