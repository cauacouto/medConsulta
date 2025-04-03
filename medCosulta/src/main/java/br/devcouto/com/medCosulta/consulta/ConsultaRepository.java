package br.devcouto.com.medCosulta.consulta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consuta, Long> {
    // Aqui você pode adicionar métodos personalizados, se necessário
    // Exemplo: List<Consulta> findByMedicoId(Long medicoId);
}
