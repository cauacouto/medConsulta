package br.com.coutodev.medconsulta.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<paciente, Long> {
}
