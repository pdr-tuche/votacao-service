package com.lifters.votacao_service.repositories;

import com.lifters.votacao_service.models.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    Optional<Candidato> findByNumero(Integer numero);
}
