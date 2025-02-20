package com.lifters.votacao_service.controllers;

import com.lifters.votacao_service.models.Eleitor;
import com.lifters.votacao_service.presentation.CreateEleitorDTO;
import com.lifters.votacao_service.presentation.UpdateEleitorDTO;
import com.lifters.votacao_service.services.EleitorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eleitores")
public class EleitorController {
    @Autowired
    private EleitorService eleitorService;

    @GetMapping("/{id}")
    public Eleitor show(@PathVariable Long id) {
        return this.eleitorService.findById(id);
    }

    @PostMapping()
    public Eleitor create(@Valid @RequestBody CreateEleitorDTO eleitorDTO) {
        return this.eleitorService.create(eleitorDTO);
    }

    @PutMapping("/{id}")
    public Eleitor update(@Valid @PathVariable Long id, @RequestBody UpdateEleitorDTO eleitorDTO) {
        return this.eleitorService.update(id, eleitorDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.eleitorService.delete(id);
    }
}
