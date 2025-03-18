package br.com.coutodev.medconsulta.paciente;

public record DadosListagemPaciente (Long id, String nome, String email, String cpf) {


    public DadosListagemPaciente(paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }


    }


