package com.yape.apitest.exceptions;

public class ConsumOptionServicesException extends AssertionError{

    public static final String ERROR_RESPONSE_CODE = "El código de respuesta no es el esperado";
    public static final String ERROR_VALIDATION = "El resultado no es el esperado";

    public ConsumOptionServicesException(String message, Throwable cause) {
        super(message, cause);
    }
}
