package io.github.apps.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.apps.dominios.ProdutosDominio;
import io.github.apps.repositorios.ProdutosRepositorio;

@Service
public class ProdutoServicos {

	@Autowired
	private ProdutosRepositorio produtosRepositorio;
	
	public List <ProdutosDominio> buscaTodos() {
		List <ProdutosDominio> lista = produtosRepositorio.findAll();
		return lista;
	}
	
	public ProdutosDominio buscar(Integer id) {
		Optional<ProdutosDominio> clientesDominio = produtosRepositorio.findById(id);
		return clientesDominio.orElse(null);
	}
	
	public void excluir(Integer id) {
		produtosRepositorio.deleteById(id);
	}

	public void salvar(ProdutosDominio produtosDominio) {
		produtosRepositorio.save(produtosDominio);
	}
	
}
