package io.github.apps.alcadas.entities;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Table(name = "USUARIOS")
@Entity
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Integer id;

	@Column(name = "NOME", nullable = false, length = 128 )
	@NotBlank(message = "NOME é obrigatório até 128 letras")
	String nome;

	@Column(name = "LOGIN", nullable = false, unique = true, length = 32 )
	@NotBlank(message = "LOGIN é obrigatório até 32 letras")
	String login;
	
	@Column(name = "SENHA", nullable = false, length = 64 )
	@NotBlank(message = "SENHA é obrigatório até 64 letras")
	String senha;
	
	@Column(name = "DATA_CADASTRO")
	LocalDateTime dataCadastro;
	
	@Column(name = "DATA_ATUALIZACAO")
	LocalDateTime dataAtualizacao;
	
	@Column(name = "NOME_ATUALIZACAO", length = 128)
	String nomeAtualizacao;

}

