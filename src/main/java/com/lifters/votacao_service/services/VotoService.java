package com.lifters.votacao_service.services;

import com.lifters.votacao_service.enums.ExceptionMessageEnum;
import com.lifters.votacao_service.models.Candidato;
import com.lifters.votacao_service.models.Eleitor;
import com.lifters.votacao_service.models.Sessao;
import com.lifters.votacao_service.models.Voto;
import com.lifters.votacao_service.presentation.CreateVotoDTO;
import com.lifters.votacao_service.repositories.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VotoService {
    @Autowired
    private VotoRepository repository;

    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private CandidatoService candidatoService;

    @Autowired
    private EleitorService eleitorService;

    public List<Voto> findVotosByCandidato(Long candidatoId) {
        return this.repository.findByCandidato(candidatoId);
    }

    public List<Voto> findVotosByEleitor(Long eleitorId) {
        return this.repository.findByEleitor(eleitorId);
    }

    public Voto votar(CreateVotoDTO votoDTO) {
        Sessao sessao = this.sessaoService.findById(votoDTO.sessaoId());

        if (!sessao.getAberta()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    ExceptionMessageEnum.SESSAO_ENCONTRASE_FECHADA.getMessage()
            );
        }

        Eleitor eleitor = this.eleitorService.findById(votoDTO.eleitorId());

        List<Voto> votoExists = this.repository.findByEleitor(eleitor.getId());

        if(!votoExists.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    ExceptionMessageEnum.ELEITOR_JA_VOTOU.getMessage()
            );
        }

        Candidato candidato = this.candidatoService.findById(votoDTO.candidatoId());

        Voto voto = Voto.builder()
                .eleitor(eleitor)
                .candidato(candidato)
                .sessao(sessao)
                .build();

        return this.repository.save(voto);
    }

    public Integer countBySessao(Long sessaoId) {
        return this.repository.countBySessao(sessaoId);
    }
}
