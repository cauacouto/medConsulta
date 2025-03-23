package br.devcouto.com.medCosulta.paciente;

import br.devcouto.com.medCosulta.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosPaciente(@NotBlank
                              String nome,
                            @NotBlank
                              String email,
                            @NotBlank
                              String cpf,
                            @NotNull @Valid
                            DadosEndereco endereco,

                            @NotBlank @Pattern(regexp = "\\d{8,9}") String telefone)  {
}
