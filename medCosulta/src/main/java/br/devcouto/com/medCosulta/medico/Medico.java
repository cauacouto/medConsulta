package br.devcouto.com.medCosulta.medico;

import br.devcouto.com.medCosulta.endereco.Endereco;
import jakarta.persistence.*;

@Entity(name = "medico")
@Table(name = "medicos")



    public class Medico {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String nome;
        private String crm;
        private String email;
        private String telefone;


        @Enumerated(EnumType.STRING)
        private especialidade especialidade;


        @Embedded
        private Endereco endereco;



    public Medico(DadosMedico dados) {
            this.nome=dados.nome();

            this.crm =dados.crm();
            this.email=dados.email();
            this.telefone=dados.telefone();
            this.endereco=new Endereco(dados.endereco());
            this.especialidade=dados.especialidade();
        }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public br.devcouto.com.medCosulta.medico.especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(br.devcouto.com.medCosulta.medico.especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Medico() {

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

    @Override
    public String toString() {
        return "medico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", crm='" + crm + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", especialidade=" + especialidade +
                ", endereco=" + endereco +
                '}';
    }
}
