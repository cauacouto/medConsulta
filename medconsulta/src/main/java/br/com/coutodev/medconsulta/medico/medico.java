package br.com.coutodev.medconsulta.medico;

import br.com.coutodev.medconsulta.endereco.DadosEndereco;
import br.com.coutodev.medconsulta.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "medico")
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String crm;
   private String email;
   private String telefone;


   @Enumerated(EnumType.STRING)
   private especialidade especialidade;


   @Embedded
   private Endereco endereco;



    public medico(DadosMedico dados) {
        this.nome=dados.nome();

        this.crm =dados.crm();
        this.email=dados.email();
        this.telefone=dados.telefone();
        this.endereco=new Endereco(dados.endereco());
        this.especialidade=dados.especialidade();
    }

    public void atualizar(DadosMedicoAtualização dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
          this.endereco.atualizarInformacoes(dados.endereco());

            }
        }


}

