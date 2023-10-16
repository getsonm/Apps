package io.github.apps.dominios;

import jakarta.persistence.Id;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ITENS_PEDIDO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItensPedidoDominio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	Integer id;
	
	@Column(name = "QUANTIDADE")
	Integer quantidade;
	
	@Column(name = "VALOR_UNITARIO", precision = 20, scale = 2)
	BigDecimal valorUnitario;
	
	@ManyToOne
	@JoinColumn(name = "PRODUTO_ID")
	ProdutosDominio produto;
	
	@ManyToOne
	@JoinColumn(name = "PEDIDO_ID")
	PedidosDominio pedido;
	
}
