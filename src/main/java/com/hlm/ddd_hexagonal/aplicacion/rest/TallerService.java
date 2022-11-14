package com.hlm.ddd_hexagonal.aplicacion.rest;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TallerService {
    List<Taller>tallers=new ArrayList<>();
    public Taller save(RequestTaller requestTaller){

        for (Taller taller:requestTaller.getTallers()) {
            this.tallers.add(taller);
        }
        return null;
    }
}
