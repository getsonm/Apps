package io.github.apps;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.apps.dominios.ClientesDominio;
import io.github.apps.dominios.ProdutosDominio;
import io.github.apps.dto.ItensPedidosDTO;
import io.github.apps.dto.PedidosDTO;
import io.github.apps.interfaces.PedidoServicos;
import io.github.apps.repositorios.ClientesRepositorio;
import io.github.apps.repositorios.ItensPedidoRepositorio;
import io.github.apps.repositorios.PedidosRepositorio;
import io.github.apps.repositorios.ProdutosRepositorio;

@SpringBootApplication
@RestController
public class AppsApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("appNome")
	String appNome;
	
	@Autowired
	ClientesRepositorio clientesRepositorio;
	
	@Autowired
	ProdutosRepositorio produtosRepositorio;
	
	@Autowired
	PedidosRepositorio pedidosRepositorio;
	
	@Autowired
	ItensPedidoRepositorio itensPedidoRepositorio;
	
	@Autowired
	PedidoServicos pedidoServicos;
	
	public static void main(String[] args) {
		SpringApplication.run(AppsApplication.class, args);		
	}
	
	
	@GetMapping("/")
	public String init() {
		return appNome;
	}

	@Override
	public void run(String... args) throws Exception {
		
		ClientesDominio clientesDominio1 = new ClientesDominio(null, "Cliente I");
		clientesRepositorio.save(clientesDominio1);
		ClientesDominio clientesDominio2 = new ClientesDominio(null, "Cliente II");
		clientesRepositorio.save(clientesDominio2);
		ClientesDominio clientesDominio3 = new ClientesDominio(null, "Cliente III");
		clientesRepositorio.save(clientesDominio3);
		ClientesDominio clientesDominio4 = new ClientesDominio(null, "Cliente IV");
		clientesRepositorio.save(clientesDominio4);
		
		ProdutosDominio produtosDominio1 = new ProdutosDominio(null, "Produto I", BigDecimal.valueOf(12.10), "Breve descição para produto I");
		produtosRepositorio.save(produtosDominio1);
		ProdutosDominio produtosDominio2 = new ProdutosDominio(null, "Produto II", BigDecimal.valueOf(1.35), "Breve descição para produto II");
		produtosRepositorio.save(produtosDominio2);
		ProdutosDominio produtosDominio3 = new ProdutosDominio(null, "Produto III", BigDecimal.valueOf(7.40), "Breve descição para produto III");
		produtosRepositorio.save(produtosDominio3);
		ProdutosDominio produtosDominio4 = new ProdutosDominio(null, "Produto IV", BigDecimal.valueOf(18.37), "Breve descição para produto IV");
		produtosRepositorio.save(produtosDominio4);
		ProdutosDominio produtosDominio5 = new ProdutosDominio(null, "Produto V", BigDecimal.valueOf(19.09), "Breve descição para produto V");
		produtosRepositorio.save(produtosDominio5);
		ProdutosDominio produtosDominio6 = new ProdutosDominio(null, "Produto VI", BigDecimal.valueOf(4.35), "Breve descição para produto VI");
		produtosRepositorio.save(produtosDominio6);

		PedidosDTO pedidosDTO = new PedidosDTO();
		ItensPedidosDTO itensPedidosDTO1 = new ItensPedidosDTO(1, 1);
		ItensPedidosDTO itensPedidosDTO2 = new ItensPedidosDTO(2, 2);
		ItensPedidosDTO itensPedidosDTO3 = new ItensPedidosDTO(3, 1);
		ItensPedidosDTO itensPedidosDTO4 = new ItensPedidosDTO(4, 2);
		ItensPedidosDTO itensPedidosDTO5 = new ItensPedidosDTO(5, 1);
		List<ItensPedidosDTO> item = new ArrayList<>();
		pedidosDTO.setCliente(1);
		item.add(itensPedidosDTO1);
		item.add(itensPedidosDTO2);
		item.add(itensPedidosDTO3);
		item.add(itensPedidosDTO4);
		item.add(itensPedidosDTO5);
		pedidosDTO.setItens(item);
		pedidoServicos.salvar(pedidosDTO);
		
		pedidosDTO.setCliente(2);
		pedidosDTO.setItens(item);
		pedidoServicos.salvar(pedidosDTO);
		
		pedidosDTO.setCliente(3);
		pedidosDTO.setItens(item);
		pedidoServicos.salvar(pedidosDTO);
		
		pedidosDTO.setCliente(4);
		pedidosDTO.setItens(item);
		pedidoServicos.salvar(pedidosDTO);

	}

}
