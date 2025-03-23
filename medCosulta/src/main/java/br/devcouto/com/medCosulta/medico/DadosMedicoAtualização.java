package br.devcouto.com.medCosulta.medico;

import br.devcouto.com.medCosulta.endereco.DadosEndereco;
import org.antlr.v4.runtime.misc.NotNull;

public record DadosMedicoAtualização (@NotNull
                                     Long id,
                                     String nome ,
                                     String telefone,
                                     DadosEndereco endereco) {
}
