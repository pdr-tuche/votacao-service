package com.lifters.votacao_service.controllers;

import com.lifters.votacao_service.models.Voto;
import com.lifters.votacao_service.presentation.CreateVotoDTO;
import com.lifters.votacao_service.services.VotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votos")
public class VotoController {
    @Autowired
    private VotoService service;

    @PostMapping
    public Voto registrarVoto(@Valid @RequestBody CreateVotoDTO voto){
        return this.service.votar(voto);
    }
}