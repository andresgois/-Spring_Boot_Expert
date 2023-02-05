package io.gtihub.andresgois.rest.controller;

import io.gtihub.andresgois.domain.entity.ItemPedido;
import io.gtihub.andresgois.domain.entity.Pedido;
import io.gtihub.andresgois.domain.enums.StatusPedido;
import io.gtihub.andresgois.rest.dto.AtualizacaoStatusPedidoDTO;
import io.gtihub.andresgois.rest.dto.InformacoesItemPedidoDTO;
import io.gtihub.andresgois.rest.dto.InformacoesPedidoDTO;
import io.gtihub.andresgois.rest.dto.PedidoDTO;
import io.gtihub.andresgois.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    private PedidoService service;

    public PedidosController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody PedidoDTO dto){
        Pedido pedido = service.salvar(dto);
        return pedido.getId();
    }

    @GetMapping("{id}")
    public InformacoesPedidoDTO getById(@PathVariable Integer id){
        return service.obterPedidoCompleto(id)
                .map( p -> converter(p))
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado!")
                );
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable Integer id, @RequestBody AtualizacaoStatusPedidoDTO dto){
        String novoStatus = dto.getNovoStatus();
        service.atualizaStatus(id, StatusPedido.valueOf(novoStatus));
    }

    private InformacoesPedidoDTO converter(Pedido p) {
        return InformacoesPedidoDTO
                .builder()
                .codigo(p.getId())
                .dataPedido(p.getDataPedido()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .cpf(p.getCliente().getCpf())
                .nomeCliente(p.getCliente().getNome())
                .total(p.getTotal())
                .status(p.getStatus().name())
                .items(converterItens(p.getItens()))
                .build();
    }

    private List<InformacoesItemPedidoDTO> converterItens(List<ItemPedido> itens){
        if(CollectionUtils.isEmpty(itens)){
            return Collections.emptyList();
        }

        return itens
                .stream()
                .map(
                        item -> InformacoesItemPedidoDTO
                                .builder()
                                .descricaoProduto(item.getProduto().getDescricao())
                                .precoUnitario(item.getProduto().getPreco())
                                .quantidade(item.getQuantidade())
                                .build()
                ).collect(Collectors.toList());
    }


}
