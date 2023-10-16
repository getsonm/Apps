package io.github.apps.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.apps.dominios.PedidosDominio;

public interface PedidosRepositorio extends JpaRepository<PedidosDominio, Integer> {

	@Query(" select p from PedidosDominio p left join fetch p.itens where p.id = :id ")
    Optional<PedidosDominio> findByIdFetchItens(@Param("id") Integer id);
	
}
