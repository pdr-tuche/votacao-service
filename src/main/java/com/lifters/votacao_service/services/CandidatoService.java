package com.lifters.votacao_service.services;

import com.lifters.votacao_service.enums.ExceptionMessageEnum;
import com.lifters.votacao_service.models.Candidato;
import com.lifters.votacao_service.presentation.CreateCandidatoDTO;
import com.lifters.votacao_service.repositories.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CandidatoService {
    @Autowired
    private CandidatoRepository repository;

    public Candidato create(CreateCandidatoDTO candidatoDTO) {
        if (this.repository.findByNumero(candidatoDTO.numero()).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    ExceptionMessageEnum
                            .CANDIDATO_ALREADY_EXISTS
                            .getMessage(
                                    candidatoDTO.numero()
                            )
            );
        }

        Candidato candidato = Candidato.builder()
                .nome(candidatoDTO.nome())
                .numero(candidatoDTO.numero())
                .build();

        return this.repository.save(candidato);
    }

    public Candidato findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
