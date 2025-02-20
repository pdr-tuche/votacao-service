package com.lifters.votacao_service.controllers;

import com.lifters.votacao_service.models.Sessao;
import com.lifters.votacao_service.presentation.CreateSessaoDTO;
import com.lifters.votacao_service.services.SessaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

    @PostMapping("/criar-sessao")
    public Sessao criarSessao(@Valid @RequestBody CreateSessaoDTO sessaoDTO) {
        return sessaoService.create(sessaoDTO);
    }

    @PostMapping("/abrir-sessao")
    public Sessao criarSessao(@Valid @RequestBody Sessao novaSessao) {
        return this.sessaoService.abrirSessao(novaSessao);
    }

    @PutMapping("/{id}/abrir-sessao")
    public Sessao abrirSessao(@PathVariable Long id) {
        return sessaoService.abrirSessao(id);
    }

    @PatchMapping("/{id}/fechar-sessao")
    public Sessao encerrarSessao(@PathVariable Long id) {
        return this.sessaoService.encerrarSessao(id);
    }
}