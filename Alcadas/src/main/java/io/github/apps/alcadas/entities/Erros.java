package io.github.apps.alcadas.entities;

import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class Erros {

    private List<String> erros;

    public Erros(List<String> errors) {
        this.erros = errors;
    }

    public Erros(String mensagemErro){
        this.erros = Arrays.asList(mensagemErro);
    }
    
}
