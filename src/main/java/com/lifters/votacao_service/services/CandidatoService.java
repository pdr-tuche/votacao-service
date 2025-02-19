package com.lifters.votacao_service.services;

import com.lifters.votacao_service.models.Candidato;
import com.lifters.votacao_service.presentation.CreateCandidatoDTO;
import com.lifters.votacao_service.repositories.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {
    @Autowired
    private CandidatoRepository repository;

    public Candidato create(CreateCandidatoDTO candidatoDTO) {
        Candidato candidato = Candidato.builder()
                .nome(candidatoDTO.nome())
                .numero(candidatoDTO.numero())
                .build();
        return this.repository.save(candidato);
    }
}
