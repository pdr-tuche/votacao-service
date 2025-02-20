package com.lifters.votacao_service.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    @JsonManagedReference
    private Cargo cargo;

    @Override
    public String toString() {
        return "Candidato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numero=" + numero +
                ", cargoId=" + (cargo != null ? cargo.getId() : null) +
                "}";
    }

}
