package com.lifters.votacao_service.repositories;

import com.lifters.votacao_service.models.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
    Optional<Cargo> findByNome(@Param("nome") String nome);

    @Query("SELECT DISTINCT c FROM Cargo c")
    List<Cargo> getAll();
}
