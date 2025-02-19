package com.lifters.votacao_service.repositories;

import com.lifters.votacao_service.models.Eleitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EleitorRepository extends JpaRepository<Eleitor, Long> {
    @Query("SELECT e FROM Eleitor e WHERE e.cpf = :cpf")
    Optional<Eleitor> findByCpf(@Param("cpf") String cpf);
}
