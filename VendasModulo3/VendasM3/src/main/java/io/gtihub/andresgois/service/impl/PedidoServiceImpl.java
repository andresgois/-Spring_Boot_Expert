package io.gtihub.andresgois.service.impl;

import io.gtihub.andresgois.domain.repository.PedidoRepository;
import io.gtihub.andresgois.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
}
