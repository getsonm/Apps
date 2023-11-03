package io.github.apps.alcadas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import io.github.apps.alcadas.entities.Usuarios;


@Repository
public interface UsuariosRepo extends JpaRepository<Usuarios, Integer> {

	@Query("select 'Excluido'")
	String excluido();
	
	Usuarios findByNomeLike(String nome);

}
