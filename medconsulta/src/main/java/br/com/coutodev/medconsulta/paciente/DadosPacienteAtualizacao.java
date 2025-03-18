package br.com.coutodev.medconsulta.paciente;

import br.com.coutodev.medconsulta.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosPacienteAtualizacao (@NotNull Long id , String nome, String Telefone , DadosEndereco endereco) {
}
