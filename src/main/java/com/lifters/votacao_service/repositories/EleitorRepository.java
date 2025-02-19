package com.lifters.votacao_service.repositories;

import com.lifters.votacao_service.models.Eleitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EleitorRepository extends JpaRepository<Eleitor, Long> {
}
