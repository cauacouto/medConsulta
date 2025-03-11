package br.com.coutodev.medconsulta.contrroller;

import br.com.coutodev.medconsulta.dto.DadosMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public void CadastrarMedico(@RequestBody DadosMedico dados) {
        System.out.println(dados);
    }
}
