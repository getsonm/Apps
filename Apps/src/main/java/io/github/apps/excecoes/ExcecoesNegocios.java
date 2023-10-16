package io.github.apps.excecoes;

public class ExcecoesNegocios extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcecoesNegocios(String mensagem) {
        super(mensagem);
    }
	
}
