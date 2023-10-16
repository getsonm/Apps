package io.github.apps.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.apps.dominios.ItensPedidoDominio;

public interface ItensPedidoRepositorio extends JpaRepository<ItensPedidoDominio, Integer> {

}
