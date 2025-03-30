package br.devcouto.com.medCosulta.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException e){
        var erro = e.getFieldErrors();
        return ResponseEntity.badRequest().body(erro .stream().map(DadosErroDeValidacao::new).toList());

    }
    private record DadosErroDeValidacao(String campo, String mensagem) {

        public DadosErroDeValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }

    }
}
