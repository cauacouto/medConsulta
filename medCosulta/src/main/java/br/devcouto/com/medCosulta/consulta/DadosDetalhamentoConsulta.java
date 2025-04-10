package br.devcouto.com.medCosulta.consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long idMedico, Long idPaciente, LocalDateTime data)
{
    public DadosDetalhamentoConsulta(Consulta consulta) {
        this(consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}
