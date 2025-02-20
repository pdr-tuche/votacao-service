package com.lifters.votacao_service.enums;

public enum ExceptionMessageEnum {
    CANDIDATO_ALREADY_EXISTS("O numero %d ja está em uso."),
    CANDIDATO_NAO_PODE_SER_EXCLUIDO("o candidato não pode ser excluido, pois possui votos"),
    ELEITOR_NAO_PODE_SER_EXCLUIDO("o eleitor não pode ser excluido, pois já votou."),
    ELEITOR_NAO_ENCONTRADO("o eleitor nao foi encontrado."),
    CPF_NAO_DISPONIVEL("este cpf não esta disponivel."),
    CARGO_JA_EXISTENTE("o cargo %s já existe."),
    CARGO_NAO_ENCONTRADO("cargo não encontrado."),
    CARGO_NAO_PODE_SER_EXCLUIDO("cargo nao pode ser excluido pois há candidatos concorrendo."),
    SESSAO_NAO_ENCONTRADA("Sessao não encontrada."),
    SESSAO_ENCONTRASE_FECHADA("Sessão já encontra-se encerrada!"),
    SESSAO_ENCONTRASE_ABERTA("A sessao ja encontra-se aberta.");

    private final String message;

    ExceptionMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}