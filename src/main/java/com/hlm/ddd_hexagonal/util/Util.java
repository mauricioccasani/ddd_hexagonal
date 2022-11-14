package com.hlm.ddd_hexagonal.util;

import com.hlm.ddd_hexagonal.infraestructura.datos.ExeptionUtil;

public  class Util {
    public static  boolean valid(String valor)throws ExeptionUtil {
        if (valor.isEmpty()){
            throw new ExeptionUtil("Error =========================: ");
        }
        return true;
    }
}
