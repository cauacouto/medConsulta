package br.com.coutodev.medconsulta.medico;

import br.com.coutodev.medconsulta.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosMedicoAtualização
        (@NotNull
         Long id,
         String nome ,
         String telefone,
         DadosEndereco endereco) {
}
