package io.github.apps.dominios;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CLIENTES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientesDominio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	Integer id;
	
	@Column(name = "NOME")
	String nome;
	
	/*@OneToMany( mappedBy = "cliente" , fetch = FetchType.LAZY )
    Set<PedidosDominio> pedidos;*/

}
