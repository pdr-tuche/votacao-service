package com.lifters.votacao_service.controllers;

import com.lifters.votacao_service.models.Candidato;
import com.lifters.votacao_service.models.Cargo;
import com.lifters.votacao_service.presentation.CreateCandidatoDTO;
import com.lifters.votacao_service.presentation.UpdateCandidatoDTO;
import com.lifters.votacao_service.services.CandidatoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CandidatoControllerTest {

    @InjectMocks
    private CandidatoController candidatoController;

    @Mock
    private CandidatoService candidatoService;

    private Candidato candidato;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        candidato = Candidato.builder()
                .id(1L)
                .nome("Candidato Teste")
                .cargo(Cargo.builder().id(1L).nome("Presidente").build())
                .build();
    }

    @Test
    void shouldReturnCandidato_whenValidId() {
        when(candidatoService.findById(1L)).thenReturn(this.candidato);

        candidatoController.show(1L);;
        verify(candidatoService, times(1)).findById(1L);
    }

    @Test
    void shouldCreateCandidato_whenValidData() {
        CreateCandidatoDTO candidatoDTO = new CreateCandidatoDTO("Candidato Teste", 1, 1L);

        when(candidatoService.create(any(CreateCandidatoDTO.class))).thenReturn(candidato);

        candidatoController.create(candidatoDTO);

        verify(candidatoService, times(1)).create(any(CreateCandidatoDTO.class));
    }

    @Test
    void shouldUpdateCandidato_whenValidData() {
        UpdateCandidatoDTO updateDTO = new UpdateCandidatoDTO("test", 123, 1L);

        when(candidatoService.update(eq(1L), any(UpdateCandidatoDTO.class))).thenReturn(candidato);

        candidatoController.update(1L, updateDTO);

        verify(candidatoService, times(1)).update(eq(1L), any(UpdateCandidatoDTO.class));
    }

    @Test
    void shouldDeleteCandidato_whenValidId() {
        doNothing().when(candidatoService).delete(1L);

        assertDoesNotThrow(() -> candidatoController.delete(1L));

        verify(candidatoService, times(1)).delete(1L);
    }
}