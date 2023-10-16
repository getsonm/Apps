package io.github.apps.dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacoesPedidoDTO {
    private Integer idPedido;
    private String nomeCliente;
    private Date dataPedido;
    private List<InformacaoItemPedidoDTO> items;
}
