package io.github.apps.dto;

import lombok.Getter;
import java.util.Arrays;
import java.util.List;

public class Excecoes {

	@Getter
    private List<String> errosEncontrados;

    public Excecoes(String mensagemErro) {
    	
        this.errosEncontrados = Arrays.asList(mensagemErro);
        
    }
    
}
