package br.devcouto.com.medCosulta.consulta;

import br.devcouto.com.medCosulta.medico.especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(Long idMedico,
                                       @NotNull
                                       Long idPaciente,
                                       @NotNull
                                       @Future
                                       LocalDateTime data,
                                       especialidade especialidade



) {
}
