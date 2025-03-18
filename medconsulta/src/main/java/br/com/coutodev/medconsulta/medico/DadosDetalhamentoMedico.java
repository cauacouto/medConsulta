package br.com.coutodev.medconsulta.medico;

import br.com.coutodev.medconsulta.endereco.Endereco;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone, especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedico(medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}

