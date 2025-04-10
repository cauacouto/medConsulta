package br.devcouto.com.medCosulta.consulta.validações;

import br.devcouto.com.medCosulta.consulta.DadosAgendamentoConsulta;
import br.devcouto.com.medCosulta.consulta.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class validadorDeHorarioDeFuncionamento implements ValidadorAgendamentoConsulta {


    public void validarHorarioDeFuncionamento(DadosAgendamentoConsulta dados) {



        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);

        var horaDeAbertura = dataConsulta.getHour() < 7;
        var horaDeFechamento = dataConsulta.getHour() > 18;

        if (domingo || horaDeAbertura || horaDeFechamento) {
            throw new ValidacaoException("Consulta fora do horário de funcionamento");
        }

    }


    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        validarHorarioDeFuncionamento(dados);
    }
}
