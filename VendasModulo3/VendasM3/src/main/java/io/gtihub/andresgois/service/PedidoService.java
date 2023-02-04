package io.gtihub.andresgois.service;

import io.gtihub.andresgois.domain.entity.Pedido;
import io.gtihub.andresgois.rest.dto.PedidoDTO;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);
}
