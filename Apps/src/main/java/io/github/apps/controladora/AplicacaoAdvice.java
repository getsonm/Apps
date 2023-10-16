package io.github.apps.controladora;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.apps.dto.Excecoes;
import io.github.apps.excecoes.ExcecoesNegocios;

@RestControllerAdvice
public class AplicacaoAdvice {

	@ExceptionHandler(ExcecoesNegocios.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Excecoes handleRegraNegocioException(ExcecoesNegocios ex) {
		
        String erro = ex.getMessage();
        return new Excecoes(erro);
        
    }
	
}
