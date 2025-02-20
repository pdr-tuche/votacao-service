package com.lifters.votacao_service.services;

import com.lifters.votacao_service.enums.ExceptionMessageEnum;
import com.lifters.votacao_service.models.Sessao;
import com.lifters.votacao_service.presentation.CreateSessaoDTO;
import com.lifters.votacao_service.repositories.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SessaoService {
    @Autowired
    private SessaoRepository repository;

    public Sessao create(CreateSessaoDTO dto) {
        Sessao sessao = Sessao.builder()
                .nome(dto.nome())
                .aberta(false)
                .build();
        return repository.save(sessao);
    }

    public Sessao abrirSessao(Sessao sessao) {
        if (sessao.getAberta()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    ExceptionMessageEnum.SESSAO_ENCONTRASE_ABERTA.getMessage()
            );
        }
        sessao.setAberta(true);
        return repository.save(sessao);
    }

    public Sessao abrirSessao(Long id) {
        Sessao sessao = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        ExceptionMessageEnum.SESSAO_NAO_ENCONTRADA.getMessage()
                ));

        if (sessao.getAberta()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    ExceptionMessageEnum.SESSAO_ENCONTRASE_ABERTA.getMessage()
            );
        }

        sessao.setAberta(true);
        return repository.save(sessao);
    }

    public Sessao encerrarSessao(Long id) {
        Sessao sessao = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        ExceptionMessageEnum.SESSAO_NAO_ENCONTRADA.getMessage()
                ));

        if (!sessao.getAberta()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    ExceptionMessageEnum.SESSAO_ENCONTRASE_FECHADA.getMessage()
            );
        }

        //TODO: verifficar se nessa sessao ha menos de dois votos para poder encerrar

        sessao.setAberta(false);
        return repository.save(sessao);

        return sessao;
    }
}