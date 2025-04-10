package br.devcouto.com.medCosulta.consulta.validações;

import br.devcouto.com.medCosulta.consulta.ConsultaRepository;
import br.devcouto.com.medCosulta.consulta.DadosAgendamentoConsulta;
import br.devcouto.com.medCosulta.consulta.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class validadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoConsulta {

    @Autowired
    private ConsultaRepository Repository;


    public void validar(DadosAgendamentoConsulta dados) {

        var primeiroHorario= dados.data().withHour(7);
        var ultimoHorario= dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = Repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario,ultimoHorario);

        if (pacientePossuiOutraConsultaNoDia) {
            throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia");
        }
    }
}
