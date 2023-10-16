package io.github.apps.interfaces;

import java.util.List;
import java.util.Optional;

import io.github.apps.dominios.ItensPedidoDominio;
import io.github.apps.dominios.PedidosDominio;
import io.github.apps.dto.InformacaoItemPedidoDTO;
import io.github.apps.dto.InformacoesPedidoDTO;
import io.github.apps.dto.PedidosDTO;

public interface PedidoServicos {

	PedidosDominio salvar( PedidosDTO dto );

	Optional<PedidosDominio> obterPedidoCompleto(Integer id);
	
	public InformacoesPedidoDTO converter(PedidosDominio pedido);
	
	public List<InformacaoItemPedidoDTO> converter(List<ItensPedidoDominio> itens);

}
