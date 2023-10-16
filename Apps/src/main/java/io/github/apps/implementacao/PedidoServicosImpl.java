package io.github.apps.implementacao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import io.github.apps.dominios.ClientesDominio;
import io.github.apps.dominios.ItensPedidoDominio;
import io.github.apps.dominios.PedidosDominio;
import io.github.apps.dominios.ProdutosDominio;
import io.github.apps.dto.InformacaoItemPedidoDTO;
import io.github.apps.dto.InformacoesPedidoDTO;
import io.github.apps.dto.ItensPedidosDTO;
import io.github.apps.dto.PedidosDTO;
import io.github.apps.excecoes.ExcecoesNegocios;
import io.github.apps.interfaces.PedidoServicos;
import io.github.apps.repositorios.ClientesRepositorio;
import io.github.apps.repositorios.ItensPedidoRepositorio;
import io.github.apps.repositorios.PedidosRepositorio;
import io.github.apps.repositorios.ProdutosRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServicosImpl implements PedidoServicos {
	
	final PedidosRepositorio repository;
	final ClientesRepositorio clientesRepository;
	final ProdutosRepositorio produtosRepository;
	final ItensPedidoRepositorio itemsPedidoRepository;
	    
	 @Override
	 @Transactional
	 public PedidosDominio salvar( PedidosDTO dto ) {
		 
	        ClientesDominio cliente = clientesRepository
	                .findById(dto.getCliente())
	                .orElseThrow(() -> new ExcecoesNegocios("CLIENTE INVÁLIDO"));

	        PedidosDominio pedido = new PedidosDominio();
	        pedido.setDataPedido(Date.valueOf(LocalDate.now()));
	        pedido.setCliente(cliente);

	        List<ItensPedidoDominio> itemsPedido = converterItems(pedido, dto.getItens());
	        repository.save(pedido);
	        itemsPedidoRepository.saveAll(itemsPedido);
	        pedido.setItens(itemsPedido);
	        return pedido;
	        
	 }

	 List<ItensPedidoDominio> converterItems(PedidosDominio pedidosDominio, List<ItensPedidosDTO> itens){
	    	
	        if(itens.isEmpty()){
	            throw new ExcecoesNegocios("PEDIDO SEM ITENS");
	        }

	        return itens
	                
	        		.stream()
	                .map( dto -> {
	                    ProdutosDominio produtosDominio = produtosRepository
	                            .findById(dto.getProduto())
	                            .orElseThrow(
	                                    () -> new ExcecoesNegocios(
	                                            "PRODUTO INVÁLIDO"
	                                    ));

	                    ItensPedidoDominio itensPedidoDominio = new ItensPedidoDominio();
	                    itensPedidoDominio.setQuantidade(dto.getQuantidade());
	                    itensPedidoDominio.setPedido(pedidosDominio);
	                    itensPedidoDominio.setProduto(produtosDominio);
	                    itensPedidoDominio.setValorUnitario(produtosDominio.getValorUnitario());
	                    return itensPedidoDominio;
	                    
	                }).collect(Collectors.toList());

	 }

	@Override
	public Optional<PedidosDominio> obterPedidoCompleto(Integer id) {
		return repository.findByIdFetchItens(id);
	}
	
	public InformacoesPedidoDTO converter(PedidosDominio pedido) {
	        return InformacoesPedidoDTO
	                .builder()
	                .idPedido(pedido.getId())
	                .dataPedido(pedido.getDataPedido())
	                .nomeCliente(pedido.getCliente().getNome())
	                .items(converter(pedido.getItens()))
	                .build();
	    }

	public List<InformacaoItemPedidoDTO> converter(List<ItensPedidoDominio> itens) {
	        if(CollectionUtils.isEmpty(itens)){
	            return Collections.emptyList();
	        }
	        return itens.stream().map(
	                item -> InformacaoItemPedidoDTO
	                            .builder().descricaoProduto(item.getProduto().getDescricao())
	                            .precoUnitario(item.getProduto().getValorUnitario())
	                            .quantidade(item.getQuantidade())
	                            .build()
	        ).collect(Collectors.toList());
	    }
}
