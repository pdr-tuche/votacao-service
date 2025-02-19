package com.lifters.votacao_service.services;

import com.lifters.votacao_service.enums.ExceptionMessageEnum;
import com.lifters.votacao_service.models.Candidato;
import com.lifters.votacao_service.models.Voto;
import com.lifters.votacao_service.presentation.CreateCandidatoDTO;
import com.lifters.votacao_service.repositories.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoService {
    @Autowired
    private CandidatoRepository repository;
    @Autowired
    private VotoService votoService;

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

    public Candidato update(Long id, CreateCandidatoDTO candidatoDTO) {
        Candidato candidato = this.findById(id);
        if (candidatoDTO.numero() != null) {
            Optional<Candidato> numeroCandidato = this.repository.findByNumero(candidatoDTO.numero());

            if (numeroCandidato.isPresent() && !numeroCandidato.get().getId().equals(candidato.getId())) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        ExceptionMessageEnum
                                .CANDIDATO_ALREADY_EXISTS
                                .getMessage(
                                        candidatoDTO.numero()
                                )
                );
            }

            candidato.setNumero(candidatoDTO.numero());
        }

        candidato.setNome(candidatoDTO.nome());
        return this.repository.save(candidato);
    }

    public void delete(Long id) {
        List<Voto> votosCandidato = this.votoService.findVotosByCandidato(id);

        if (!votosCandidato.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    ExceptionMessageEnum.CANDIDATO_NAO_PODE_SER_EXCLUIDO.getMessage()
            );
        }

        this.repository.deleteById(id);
    }
}
