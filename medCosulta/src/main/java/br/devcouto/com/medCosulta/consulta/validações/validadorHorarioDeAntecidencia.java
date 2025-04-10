package br.devcouto.com.medCosulta.consulta.validações;

import br.devcouto.com.medCosulta.consulta.DadosAgendamentoConsulta;
import br.devcouto.com.medCosulta.consulta.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
@Component
public class validadorHorarioDeAntecidencia  implements ValidadorAgendamentoConsulta {


    public void validarHorarioDeAntecidencia(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();

        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com pelo menos 30 minutos de antecedência");
        }
    }

    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        validarHorarioDeAntecidencia(dados);
    }
}
