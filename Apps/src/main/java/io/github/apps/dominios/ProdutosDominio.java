package io.github.apps.dominios;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUTOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutosDominio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	Integer id;
	
	@Column(name = "NOME")
	String nome;
	
	@Column(name = "VALOR_UNITARIO", precision = 20, scale = 2)
	BigDecimal valorUnitario;
	
	@Column(name = "DESCRICAO")
	String descricao;
	
}
