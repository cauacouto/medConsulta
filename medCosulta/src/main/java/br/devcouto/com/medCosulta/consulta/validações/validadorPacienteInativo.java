package br.devcouto.com.medCosulta.consulta.validações;

import br.devcouto.com.medCosulta.consulta.DadosAgendamentoConsulta;
import br.devcouto.com.medCosulta.consulta.ValidacaoException;
import br.devcouto.com.medCosulta.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class validadorPacienteInativo implements ValidadorAgendamentoConsulta {

    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        validarPacienteInativo(dados);
    }


@Autowired
private  PacienteRepository Repository;
    public void validarPacienteInativo(DadosAgendamentoConsulta dados) {

        var pacienteAtivo = Repository.existsById(dados.idPaciente());
        if (!pacienteAtivo) {
            throw new ValidacaoException("Paciente inativo");
        }
    }
}
