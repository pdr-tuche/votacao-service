package com.lifters.votacao_service.controllers;

import com.lifters.votacao_service.models.Voto;
import com.lifters.votacao_service.services.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votos")
public class VotoController {
    @Autowired
    private VotoService service;

    @PostMapping
    public ResponseEntity<Voto> registrarVoto(){
        //TODO: implementar voto.
        return ResponseEntity.ok().build();
    }
}