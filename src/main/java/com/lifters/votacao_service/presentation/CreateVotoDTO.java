package com.lifters.votacao_service.presentation;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateVotoDTO(
        @NotNull(message = "o campo 'eleitorId' nao pode ter valor null")
        @Positive(message = "o campo 'eleitorId' deve ser um numero positivo.")
        Long eleitorId,

        @NotNull(message = "o campo 'candidatoId' nao pode ter valor null")
        @Positive(message = "o campo 'candidatoId' deve ser um numero positivo.")
        Long candidatoId,

        @NotNull(message = "o campo 'sessaoId' nao pode ter valor null")
        @Positive(message = "o campo 'sessaoId' deve ser um numero positivo.")
        Long sessaoId
) {
}
