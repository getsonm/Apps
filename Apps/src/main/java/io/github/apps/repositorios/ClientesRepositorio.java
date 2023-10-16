package io.github.apps.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.apps.dominios.ClientesDominio;

public interface ClientesRepositorio extends JpaRepository<ClientesDominio, Integer> {

}
