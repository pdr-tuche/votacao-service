package com.lifters.votacao_service.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "cargo")
    @JsonBackReference
    private List<Candidato> candidatos;

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                "}";
    }
}
