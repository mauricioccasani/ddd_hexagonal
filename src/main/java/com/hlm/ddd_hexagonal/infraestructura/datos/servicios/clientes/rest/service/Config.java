package com.hlm.ddd_hexagonal.infraestructura.datos.servicios.clientes.rest.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
@Configuration
public class Config {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(4000))
                .setReadTimeout(Duration.ofMillis(4000))
                .build();
    }
}
