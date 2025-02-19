package com.lifters.votacao_service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "eleitor_id")
    private Eleitor eleitor;

    @ManyToOne
    @JoinColumn(nullable = false, name = "candidato_id")
    private Candidato candidato;
}