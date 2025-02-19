package com.lifters.votacao_service.enums;

public enum ExceptionMessageEnum {
    CANDIDATO_ALREADY_EXISTS("O numero %d ja está em uso."),
    CANDIDATO_NAO_PODE_SER_EXCLUIDO("o candidato não pode ser excluido, pois possui votos"),
    ELEITOR_NAO_PODE_SER_EXCLUIDO("o eleitor não pode ser excluido, pois já votou."),
    ELEITOR_NAO_ENCONTRADO("o eleitor nao foi encontrado."),
    CPF_NAO_DISPONIVEL("este cpf não esta disponivel.");

    private final String message;

    ExceptionMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}