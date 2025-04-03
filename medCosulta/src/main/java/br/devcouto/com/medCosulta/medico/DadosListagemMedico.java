package br.devcouto.com.medCosulta.medico;

public record DadosListagemMedico(Long id,String nome, String email, String crm, especialidade especialidade ) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}

