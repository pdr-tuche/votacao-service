package com.lifters.votacao_service.repositories;

import com.lifters.votacao_service.models.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VotoRepository extends JpaRepository<Voto, Long> {
    @Query("SELECT v FROM Voto v WHERE v.candidato.id = :candidatoId")
    List<Voto> findByCandidato(@Param("candidatoId") Long candidatoId);
}
