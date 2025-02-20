package com.lifters.votacao_service.services;

import com.lifters.votacao_service.enums.ExceptionMessageEnum;
import com.lifters.votacao_service.models.Candidato;
import com.lifters.votacao_service.models.Cargo;
import com.lifters.votacao_service.presentation.CreateCandidatoDTO;
import com.lifters.votacao_service.presentation.UpdateCandidatoDTO;
import com.lifters.votacao_service.repositories.CandidatoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CandidatoServiceTest {

    @InjectMocks
    private CandidatoService candidatoService;

    @Mock
    private CandidatoRepository candidatoRepository;

    @Mock
    private VotoService votoService;

    @Mock
    private CargoService cargoService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateCandidatoSuccessfully() {
        Cargo cargo = new Cargo();
        cargo.setId(1L);
        cargo.setNome("Presidente");
        when(cargoService.findById(1L)).thenReturn(cargo);
        when(candidatoRepository.findByNumero(123)).thenReturn(Optional.empty());

        CreateCandidatoDTO dto = new CreateCandidatoDTO("Kaysla", 123, 1L);
        Candidato candidatoMock = Candidato.builder()
                .nome("Kaysla")
                .numero(123)
                .cargo(cargo)
                .build();

        when(candidatoRepository.save(any(Candidato.class))).thenReturn(candidatoMock);

        candidatoService.create(dto);

        verify(cargoService, times(1)).findById(1L);
        verify(candidatoRepository, times(1)).findByNumero(123);
        verify(candidatoRepository, times(1)).save(any(Candidato.class));
    }

    @Test
    void shouldNotCreateCandidatoWhenNumeroAlreadyExists() {
        Cargo cargo = new Cargo();
        cargo.setId(1L);
        cargo.setNome("Presidente");

        Candidato candidatoMock = Candidato.builder()
                .nome("Mr president")
                .numero(123)
                .cargo(cargo)
                .build();

        when(candidatoRepository.findByNumero(123)).thenReturn(Optional.of(candidatoMock));

        CreateCandidatoDTO dto = new CreateCandidatoDTO("Kaysla", 123, 1L);

        assertThatThrownBy(() -> candidatoService.create(dto))
                .isInstanceOf(ResponseStatusException.class);
        verify(candidatoRepository, times(1)).findByNumero(123);
    }

}