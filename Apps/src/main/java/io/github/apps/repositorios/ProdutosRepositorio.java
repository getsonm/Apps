package io.github.apps.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.apps.dominios.ProdutosDominio;

public interface ProdutosRepositorio extends JpaRepository<ProdutosDominio, Integer> {

}
