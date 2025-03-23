package br.devcouto.com.medCosulta.paciente;

import br.devcouto.com.medCosulta.endereco.Endereco;

public record DadosDetalhamentoPaciente(String nome, String email, String cpf, String telefone, Endereco endereco) {
    public DadosDetalhamentoPaciente(paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}
