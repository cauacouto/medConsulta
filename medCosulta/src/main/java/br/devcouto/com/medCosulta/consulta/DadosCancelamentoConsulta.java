package br.devcouto.com.medCosulta.consulta;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
        @NotNull
        Long idConsulata,
@NotNull
        motivoCancelamento motivo) {

    }

