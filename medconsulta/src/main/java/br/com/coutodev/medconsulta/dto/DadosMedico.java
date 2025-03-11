package br.com.coutodev.medconsulta.dto;

public record DadosMedico(String nome, String email, String telefone, String crm, especialidade especialidade,
                          DadosEndereco endereco) {
}
