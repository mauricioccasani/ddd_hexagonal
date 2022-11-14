package com.hlm.ddd_hexagonal.infraestructura.datos;
public class ExeptionUtil extends Exception{
    public ExeptionUtil() {
    }

    public ExeptionUtil(String message) {
        super(message);
    }

    public ExeptionUtil(String message, Throwable cause) {
        super(message, cause);
    }

    public ExeptionUtil(Throwable cause) {
        super(cause);
    }

    public ExeptionUtil(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
