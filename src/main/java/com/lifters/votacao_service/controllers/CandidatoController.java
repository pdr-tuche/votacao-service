package com.lifters.votacao_service.controllers;

import com.lifters.votacao_service.models.Candidato;
import com.lifters.votacao_service.presentation.CreateCandidatoDTO;
import com.lifters.votacao_service.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {
    @Autowired
    private CandidatoService service;

    @GetMapping("/{id}")
    public Candidato show(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PostMapping()
    public Candidato create(@RequestBody CreateCandidatoDTO candidato) {
        return this.service.create(candidato);
    }

    @PutMapping("/{id}")
    public Candidato update(@PathVariable Long id, @RequestBody CreateCandidatoDTO candidato) {
        return this.service.update(id, candidato);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}