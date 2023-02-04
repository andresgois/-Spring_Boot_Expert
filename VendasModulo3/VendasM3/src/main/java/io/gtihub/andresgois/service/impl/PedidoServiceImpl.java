package io.gtihub.andresgois.service.impl;

import io.gtihub.andresgois.domain.entity.Cliente;
import io.gtihub.andresgois.domain.entity.ItemPedido;
import io.gtihub.andresgois.domain.entity.Pedido;
import io.gtihub.andresgois.domain.entity.Produto;
import io.gtihub.andresgois.domain.repository.IClientesRepository;
import io.gtihub.andresgois.domain.repository.IProdutoRepository;
import io.gtihub.andresgois.domain.repository.ItemPedidoRepository;
import io.gtihub.andresgois.domain.repository.PedidoRepository;
import io.gtihub.andresgois.exception.RegraNegocioException;
import io.gtihub.andresgois.rest.dto.ItemPedidoDTO;
import io.gtihub.andresgois.rest.dto.PedidoDTO;
import io.gtihub.andresgois.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final IClientesRepository clientesRepository;
    private final IProdutoRepository produtoRepository;

    private final ItemPedidoRepository itemPedidoRepository;


    @Override
    @Transactional  // tudo da certo ou da rooback
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository
                .findById(idCliente)
                .orElseThrow(
                        () -> new RegraNegocioException("Código de cliente inválido: "+idCliente)
                );

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itemPedido = converterItems(pedido, dto.getItems());
        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(itemPedido);

        pedido.setItens(itemPedido);

        return pedido;
    }

    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items){
        if(items.isEmpty()){
            throw new RegraNegocioException("Não é possível realizar um pedido sem items.");
        }

        return items
                .stream()
                .map( dto ->{
                            Integer idProduto = dto.getProduto();
                            Produto produto = produtoRepository
                                    .findById(idProduto)
                                    .orElseThrow(
                                            () -> new RegraNegocioException(
                                                    "Código de produto inválido: "+idProduto
                                            ));

                            ItemPedido itemPedido = new ItemPedido();
                            itemPedido.setQuantidade(dto.getQuantidade());
                            itemPedido.setPedido(pedido);
                            itemPedido.setProduto(produto);
                            return itemPedido;
                        }).collect(Collectors.toList());
    }
}
