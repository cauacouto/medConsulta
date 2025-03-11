package br.com.coutodev.medconsulta.contrroller;


import br.com.coutodev.medconsulta.dto.DadosPaciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @PostMapping
    public void cadsatraPaciente(@RequestBody DadosPaciente dados) {
        System.out.println(dados);
    }
}
