package io.github.apps.controladora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.apps.dominios.ProdutosDominio;
import io.github.apps.servicos.ProdutoServicos;

@RestController
@RequestMapping("/produtos")
public class ProdutosControladora {

	@Autowired
	private ProdutoServicos produtoServicos;
	
	@PostMapping("/")
	public ResponseEntity <?> salvar(@RequestBody ProdutosDominio produtosDominio) {
		produtoServicos.salvar(produtosDominio);
		return this.listaCliente(produtosDominio.getId());
	}
	
	@PutMapping("/")
	public ResponseEntity <?> atualizar(@RequestBody ProdutosDominio produtosDominio) {
		produtoServicos.salvar(produtosDominio);
		return this.listaCliente(produtosDominio.getId());
	}

	@GetMapping("/{id}")
	public ResponseEntity <?> listaCliente(@PathVariable Integer id) {
		ProdutosDominio lista = produtoServicos.buscar(id);
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("")
	public ResponseEntity <?> listar() {
		List<ProdutosDominio> lista = produtoServicos.buscaTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <?> excluir(@PathVariable Integer id) {
		produtoServicos.excluir(id);
		List<ProdutosDominio> lista = produtoServicos.buscaTodos();
		return ResponseEntity.ok().body(lista);
	}
}
