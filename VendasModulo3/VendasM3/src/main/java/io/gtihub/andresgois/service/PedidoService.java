package io.gtihub.andresgois.service;

import io.gtihub.andresgois.domain.entity.Pedido;
import io.gtihub.andresgois.domain.enums.StatusPedido;
import io.gtihub.andresgois.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);
    Optional<Pedido> obterPedidoCompleto(Integer id);

    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
