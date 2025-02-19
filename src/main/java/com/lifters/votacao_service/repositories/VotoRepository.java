package com.lifters.votacao_service.repositories;

import com.lifters.votacao_service.models.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {
}
