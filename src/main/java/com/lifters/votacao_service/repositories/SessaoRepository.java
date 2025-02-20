package com.lifters.votacao_service.repositories;

import com.lifters.votacao_service.models.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {
}
