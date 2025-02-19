package com.lifters.votacao_service.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Eleitor eleitor;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Candidato candidato;
}