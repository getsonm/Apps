package io.github.apps.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.apps.dominios.ClientesDominio;
import io.github.apps.repositorios.ClientesRepositorio;

@Service
public class ClienteServicos {

	@Autowired
	private ClientesRepositorio clientesRepositorio;
	
	public List <ClientesDominio> buscaTodos() {
		List <ClientesDominio> lista = clientesRepositorio.findAll();
		return lista;
	}
	
	public ClientesDominio buscar(Integer id) {
		Optional<ClientesDominio> clientesDominio = clientesRepositorio.findById(id);
		return clientesDominio.orElse(null);
	}
	
	public void excluir(Integer id) {
		clientesRepositorio.deleteById(id);
	}

	public void salvar(ClientesDominio clientesDominio) {
		clientesRepositorio.save(clientesDominio);
	}
	
	public Boolean clienteEstaPresente(Integer id) {
		return clientesRepositorio.existsById(id);
	}
		
}
