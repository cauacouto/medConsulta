package br.devcouto.com.medCosulta.consulta;

import br.devcouto.com.medCosulta.consulta.validações.ValidadorAgendamentoConsulta;
import br.devcouto.com.medCosulta.consulta.validações.ValidadorCancelamentoDeConsulta;
import br.devcouto.com.medCosulta.medico.Medico;
import br.devcouto.com.medCosulta.medico.MedicoRepository;
import br.devcouto.com.medCosulta.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsulta {

    @Autowired
    private ConsultaRepository Consultarepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private List<ValidadorCancelamentoDeConsulta> validadorCancelamento;

    @Autowired
    private List<ValidadorAgendamentoConsulta> validadores;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {
        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("id do paciente não encotrado");
        }
        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("id do medico não encotrado");
        }

        validadores.forEach(v -> v.validar(dados));

        var medico = escolherMedico(dados);
        if (medico == null) {
            throw new ValidacaoException("Não existe médico disponível nessa data");
        }
        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var consulta = new Consulta(null, dados.data(), paciente, medico);
        Consultarepository.save(consulta);
        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }
        if (dados.especialidade() == null) {
            throw new RuntimeException("especialidade não informada");
        }
        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }

    public void cancelar(DadosCancelamentoConsulta dados) {
        if (!Consultarepository.existsById(dados.idConsulata())) {
            throw new ValidacaoException("id da consulta não encotrado");
        }
        validadorCancelamento.forEach(v -> v.validar(dados));
        var consulta = Consultarepository.getReferenceById(dados.idConsulata());
        consulta.cancelar(dados.motivo());
    }
}