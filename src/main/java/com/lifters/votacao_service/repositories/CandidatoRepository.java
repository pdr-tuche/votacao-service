package com.lifters.votacao_service.repositories;

import com.lifters.votacao_service.models.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
