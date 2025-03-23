package br.devcouto.com.medCosulta.paciente;

import br.devcouto.com.medCosulta.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosPacienteAtualizacao(@NotNull Long id , String nome, String Telefone , DadosEndereco endereco) {
}
