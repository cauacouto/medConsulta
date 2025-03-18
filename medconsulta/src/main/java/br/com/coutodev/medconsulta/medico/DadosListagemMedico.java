package br.com.coutodev.medconsulta.medico;

public record DadosListagemMedico(Long id,String nome, String email, String crm, especialidade especialidade ) {

    public DadosListagemMedico(medico medico){
        this(medico.getId(),medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
