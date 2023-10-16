package io.github.apps.dominios;

import java.sql.Date;
import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PEDIDOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidosDominio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	Integer id;
	
	@Column(name = "DATA_PEDIDO")
	Date dataPedido;
	
	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID")
	ClientesDominio cliente;
	
	@OneToMany(mappedBy = "pedido")
    List<ItensPedidoDominio> itens;

}
