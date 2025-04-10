package br.devcouto.com.medCosulta.consulta;

import br.devcouto.com.medCosulta.medico.Medico;
import br.devcouto.com.medCosulta.paciente.Paciente;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
 @Table(name = "consulta")

public class Consulta {
     @Column(name = "motivo_cancelamento")
    @Enumerated(EnumType.STRING)
    private motivoCancelamento motivoCancelamento;
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    private LocalDateTime data;
        @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public Consulta(Long id, LocalDateTime data, Paciente paciente, Medico medico) {
        this.id = id;
        this.data = data;
        this.paciente = paciente;
        this.medico = medico;

    }

    public Consulta() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void cancelar(motivoCancelamento motivo) {
        this.motivoCancelamento = motivo;
    }
}
