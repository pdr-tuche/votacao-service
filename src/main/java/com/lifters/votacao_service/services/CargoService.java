package com.lifters.votacao_service.services;

import com.lifters.votacao_service.enums.ExceptionMessageEnum;
import com.lifters.votacao_service.helpers.StringHelper;
import com.lifters.votacao_service.models.Cargo;
import com.lifters.votacao_service.presentation.CreateCargoDTO;
import com.lifters.votacao_service.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CargoService {
    @Autowired
    private CargoRepository repository;
    @Autowired
    private StringHelper stringHelper;

    public Cargo create(CreateCargoDTO dto) {
        System.out.println("aqio "+ dto.nome());
        String nome = this.stringHelper.capitalize(dto.nome());
        boolean cargoExistente = this.repository.findByNome(nome).isPresent();

        if (cargoExistente) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    ExceptionMessageEnum.CARGO_JA_EXISTENTE.getMessage(nome)
            );
        }

        Cargo cargo = Cargo.builder().nome(nome).build();
        return this.repository.save(cargo);
    }

    public Cargo findById(Long id) {
        return this.repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        ExceptionMessageEnum.CARGO_NAO_ENCONTRADO.getMessage()
                )
        );
    }

    public List<Cargo> getAll() {
        return this.repository.getAll();
    }

    public Cargo update(Long id, CreateCargoDTO dto) {
        Cargo cargo = this.findById(id);
        String nome = this.stringHelper.capitalize(dto.nome());
        boolean cargoExistente = this.repository.findByNome(nome).isPresent();

        if (cargoExistente && !cargo.getNome().equals(nome)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    ExceptionMessageEnum.CARGO_JA_EXISTENTE.getMessage(nome)
            );
        }

        cargo.setNome(nome);
        return this.repository.save(cargo);
    }

    public void delete(Long id) {
        Cargo cargo = this.findById(id);
        this.repository.delete(cargo);
    }
}
