package br.devcouto.com.medCosulta.paciente;

public record DadosListagemPacinete(Long id, String nome, String email, String cpf) {

    public DadosListagemPacinete (Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }

}
