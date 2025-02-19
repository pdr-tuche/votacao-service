package com.lifters.votacao_service.services;

import com.lifters.votacao_service.models.Eleitor;
import com.lifters.votacao_service.models.Voto;
import com.lifters.votacao_service.repositories.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotoService {
    @Autowired
    private VotoRepository repository;

    public List<Voto> findVotosByCandidato(Long candidatoId) {
        return this.repository.findByCandidato(candidatoId);
    }

    public List<Eleitor> findVotosByEleitor(Long eleitorId) {
        return this.repository.findByEleitor(eleitorId);
    }
}
