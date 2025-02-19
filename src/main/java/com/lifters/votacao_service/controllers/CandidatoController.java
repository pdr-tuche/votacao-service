package com.lifters.votacao_service.controllers;

import com.lifters.votacao_service.models.Candidato;
import com.lifters.votacao_service.presentation.CreateCandidatoDTO;
import com.lifters.votacao_service.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {
    @Autowired
    private CandidatoService service;

    @PostMapping()
    public Candidato create(@RequestBody CreateCandidatoDTO candidato) {
        return this.service.create(candidato);
    }
}