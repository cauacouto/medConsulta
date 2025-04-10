package br.devcouto.com.medCosulta.consulta.validações;

import br.devcouto.com.medCosulta.consulta.ConsultaRepository;
import br.devcouto.com.medCosulta.consulta.DadosCancelamentoConsulta;
import br.devcouto.com.medCosulta.consulta.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("validadorHorarioAntecedencia")
public class ValidadorHorarioAntecedencia implements ValidadorCancelamentoDeConsulta {

    @Autowired
private ConsultaRepository Repository;

    @Override
    public void validar(DadosCancelamentoConsulta dados) {
        var consulta = Repository.getReferenceById(dados.idConsulata());
        var agora = LocalDateTime.now();
        var diferençaDeHora = Duration.between(agora, consulta.getData()).toHours();

        if (diferençaDeHora < 24) {
            throw new ValidacaoException("Cancelamento só pode ser feito com 24 horas de antecedência");
        }
    }
}
