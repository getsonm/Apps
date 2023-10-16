package io.github.apps.controladora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import io.github.apps.dominios.PedidosDominio;
import io.github.apps.dto.InformacoesPedidoDTO;
import io.github.apps.dto.PedidosDTO;
import io.github.apps.interfaces.PedidoServicos;

@RestController
@RequestMapping("/pedidos")
public class PedidosControladora {
	
	@Autowired
	PedidoServicos service;

	@PostMapping("/")
    public InformacoesPedidoDTO save( @RequestBody PedidosDTO dto ) {
        PedidosDominio pedido = service.salvar(dto);
        return getById(pedido.getId());
    }

	@GetMapping("{id}")
    public InformacoesPedidoDTO getById( @PathVariable Integer id ) {
        return service
                .obterPedidoCompleto(id)
                .map( p -> service.converter(p) )
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"Pedido não encontrado."));
    }
	
}
