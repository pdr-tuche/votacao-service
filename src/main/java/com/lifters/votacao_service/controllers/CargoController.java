package com.lifters.votacao_service.controllers;

import com.lifters.votacao_service.models.Cargo;
import com.lifters.votacao_service.presentation.CreateCargoDTO;
import com.lifters.votacao_service.services.CargoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService service;

    @PostMapping()
    public Cargo create(@Valid @RequestBody CreateCargoDTO dto) {
        return this.service.create(dto);
    }

    @GetMapping("/{id}")
    public Cargo show(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @GetMapping()
    public List<Cargo> index() {
        return this.service.getAll();
    }

    @PutMapping("/{id}")
    public Cargo update(@PathVariable Long id, @RequestBody CreateCargoDTO dto) {
        return this.service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
