package com.lifters.votacao_service.presentation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateCandidatoDTO(
        @NotNull(message = "o campo 'nome' nao pode ter valor null.")
        @NotBlank(message = "o campo 'nome' nao pode ter valor em branco.")
        String nome,
        @NotNull(message = "o campo 'numero' nao pode ter valor null.")
        @Positive(message = "o campo 'numero' deve ser um numero positivo.")
        Integer numero,
        @NotNull(message = "o campo 'cargoId' nao pode ter valor null.")
        @Positive(message = "o campo 'cargoId' deve ser um numero positivo.")
        Long cargoId
) {
}
