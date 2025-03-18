package br.com.coutodev.medconsulta.paciente;

import br.com.coutodev.medconsulta.endereco.Endereco;

public record DadosDetalhamentoPaciente(String nome, String email, String cpf, String telefone, Endereco endereco) {

    public DadosDetalhamentoPaciente(paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}
