package br.devcouto.com.medCosulta.controller;

import br.devcouto.com.medCosulta.consulta.DadosAgendamentoConsulta;
import br.devcouto.com.medCosulta.consulta.DadosDetalhamentoConsulta;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){
        System.out.println(dados);
      return ResponseEntity.ok(new DadosDetalhamentoConsulta(null,null,null));
    }
}
