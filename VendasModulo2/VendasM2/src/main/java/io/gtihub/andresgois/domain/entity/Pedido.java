package io.gtihub.andresgois.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {

    private Integer id;
    private ClienteTeste clienteTeste;
    private LocalDate dataPedido;
    private BigDecimal total;

    public Pedido(Integer id, ClienteTeste clienteTeste, LocalDate dataPedido, BigDecimal total) {
        this.id = id;
        this.clienteTeste = clienteTeste;
        this.dataPedido = dataPedido;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClienteTeste getCliente() {
        return clienteTeste;
    }

    public void setCliente(ClienteTeste clienteTeste) {
        this.clienteTeste = clienteTeste;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
