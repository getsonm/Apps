package io.github.apps.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidosDTO {
    Integer cliente;
    List<ItensPedidosDTO> itens;
}
