package io.github.apps.alcadas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import io.github.apps.alcadas.entities.Usuarios;
import io.github.apps.alcadas.service.UsuariosServ;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuarios")
public class UsuariosControl {

	@Autowired
	UsuariosServ service;

	@GetMapping()
	public ResponseEntity<Object> listarTodos() {
		return new ResponseEntity<Object>(service.listarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> listarPorID(@PathVariable Integer id) {
		return new ResponseEntity<Object>(service.listarPeloID(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> excluirPeloID(@PathVariable Integer id) {
		return new ResponseEntity<Object>(service.excluirPeloID(id), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Object> listarPorID(@RequestBody @Valid Usuarios usuarios) {
		return new ResponseEntity<Object>(service.salvar(usuarios), HttpStatus.OK);
	}
}
