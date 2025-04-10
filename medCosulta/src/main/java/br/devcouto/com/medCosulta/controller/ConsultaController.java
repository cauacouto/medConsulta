package br.devcouto.com.medCosulta.controller;

import br.devcouto.com.medCosulta.consulta.AgendaDeConsulta;
import br.devcouto.com.medCosulta.consulta.DadosAgendamentoConsulta;
import br.devcouto.com.medCosulta.consulta.DadosCancelamentoConsulta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")

public class ConsultaController {

    @Autowired
    private AgendaDeConsulta agenda;


    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){
        var  dto= agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }
@DeleteMapping
@Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados){
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

}
