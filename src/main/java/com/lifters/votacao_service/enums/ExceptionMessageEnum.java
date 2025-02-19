package com.lifters.votacao_service.enums;

public enum ExceptionMessageEnum {
    CANDIDATO_ALREADY_EXISTS("O numero %d ja está em uso.");

    private final String message;

    ExceptionMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}