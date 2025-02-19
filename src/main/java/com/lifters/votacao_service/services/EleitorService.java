package com.lifters.votacao_service.services;

import com.lifters.votacao_service.enums.ExceptionMessageEnum;
import com.lifters.votacao_service.models.Eleitor;
import com.lifters.votacao_service.presentation.CreateEleitorDTO;
import com.lifters.votacao_service.repositories.EleitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class EleitorService {
    @Autowired
    private EleitorRepository repository;
    @Autowired
    private VotoService votoService;

    public Eleitor findById(Long id) {
        return (this.repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        ExceptionMessageEnum.ELEITOR_NAO_ENCONTRADO.getMessage()
                )
        ));
    }

    public Eleitor create(CreateEleitorDTO eleitorDTO) {
        boolean cpfExistente = this.repository.findByCpf(eleitorDTO.cpf()).isPresent();

        if (cpfExistente) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    ExceptionMessageEnum.CPF_NAO_DISPONIVEL.getMessage()
            );
        }

        Eleitor eleitor = Eleitor.builder()
                .nome(eleitorDTO.nome())
                .cpf(eleitorDTO.cpf())
                .build();

        return this.repository.save(eleitor);
    }

    public Eleitor update(Long id, CreateEleitorDTO eleitorDTO) {
        Eleitor eleitor = this.findById(id);
        eleitor.setNome(eleitorDTO.nome());

        if (eleitorDTO.cpf() != null) {
            Optional<Eleitor> eleitorExistente = this.repository.findByCpf(eleitorDTO.cpf());

            if (eleitorExistente.isPresent() && !eleitorExistente.get().getId().equals(eleitor.getId())) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        ExceptionMessageEnum.CPF_NAO_DISPONIVEL.getMessage()
                );
            }

            eleitor.setCpf(eleitorDTO.cpf());
        }

        return this.repository.save(eleitor);
    }

    public void delete(Long id) {
        Eleitor eleitor = this.findById(id);
        boolean NaoVotou = this.votoService.findVotosByEleitor(eleitor.getId()).isEmpty();

        if (!NaoVotou) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    ExceptionMessageEnum.ELEITOR_NAO_PODE_SER_EXCLUIDO.getMessage()
            );
        }

        this.repository.deleteById(id);
    }
}
