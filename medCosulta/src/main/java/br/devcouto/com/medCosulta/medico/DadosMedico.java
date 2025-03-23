package br.devcouto.com.medCosulta.medico;

import br.devcouto.com.medCosulta.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosMedico(@NotBlank String nome,
                          @NotBlank String email,
                          @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
                          @NotNull @Valid especialidade especialidade,
                          @NotNull @Valid DadosEndereco endereco,
                          @NotBlank @Pattern(regexp = "\\d{8,9}") String telefone) {
}
