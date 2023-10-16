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

import io.github.apps.dominios.ClientesDominio;
import io.github.apps.servicos.ClienteServicos;

@RestController
@RequestMapping("/clientes")
public class ClientesControladora {

	@Autowired
	private ClienteServicos clienteServicos;
	
	@PostMapping("/")
	public ResponseEntity <?> salvar(@RequestBody ClientesDominio clientesDominio) {
		clienteServicos.salvar(clientesDominio);
		return this.listaCliente(clientesDominio.getId());
	}
	
	@PutMapping("/")
	public ResponseEntity <?> atualizar(@RequestBody ClientesDominio clientesDominio) {
		clienteServicos.salvar(clientesDominio);
		return this.listaCliente(clientesDominio.getId());
	}

	@GetMapping("/{id}")
	public ResponseEntity <?> listaCliente(@PathVariable Integer id) {
		ClientesDominio lista = clienteServicos.buscar(id);
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("")
	public ResponseEntity <?> listar() {
		List<ClientesDominio> lista = clienteServicos.buscaTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <?> excluir(@PathVariable Integer id) {
		clienteServicos.excluir(id);
		List<ClientesDominio> lista = clienteServicos.buscaTodos();
		return ResponseEntity.ok().body(lista);
	}
		
}
