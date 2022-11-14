package com.hlm.ddd_hexagonal.aplicacion.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Log4j2
@RequestMapping("api")
public class TallerController {
    @PostMapping
    public ResponseEntity<?>save( @Valid  @RequestBody RequestTaller requestTaller){
        //if ()
        log.info("Request: {}",requestTaller);
        return new ResponseEntity<>(requestTaller,HttpStatus.OK);
    }
}
