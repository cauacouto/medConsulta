package br.com.coutodev.medconsulta.paciente;

import br.com.coutodev.medconsulta.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paciente")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
  private String nome;
  private String email;
  private  String cpf;
   private String telefone;

   @Embedded
   private Endereco endereco;


    public paciente(DadosPaciente dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.telefone =dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }


    public void atualizar(DadosPacienteAtualizacao dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.Telefone() != null) {
            this.telefone = dados.Telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }
}
