package io.github.apps.alcadas.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.apps.alcadas.entities.Usuarios;
import io.github.apps.alcadas.repository.UsuariosRepo;

@Service
public class UsuariosServ {

	@Autowired
	UsuariosRepo repo;
	
	public List<?> listarTodos() {
		return(repo.findAll());
	}
	
	public Optional<?> listarPeloID(Integer id) {
		return(repo.findById(id));
	}
	
	public String excluirPeloID(Integer id) {
		repo.deleteById(id);
		return(repo.excluido());
	}
	
	public Optional<?> salvar(Usuarios usuarios) {
		Usuarios usuario = repo.findByNomeLike(usuarios.getNome());
		if(usuario == null) {
			usuarios.setDataCadastro(LocalDateTime.now());
			usuarios.setNomeAtualizacao("SYSTEM");
			usuarios.setNomeCadastro("SYSTEM");
		} else {
			usuarios.setId(usuario.getId());
			usuarios.setDataCadastro(usuario.getDataCadastro());
			usuarios.setNomeCadastro(usuario.getNomeCadastro());
		}
		usuarios.setDataAtualizacao(LocalDateTime.now());
		repo.save(usuarios);
		return(repo.findById(usuarios.getId()));
	}
}
