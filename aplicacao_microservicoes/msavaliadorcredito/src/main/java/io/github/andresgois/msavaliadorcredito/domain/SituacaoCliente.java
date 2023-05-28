package io.github.andresgois.msavaliadorcredito.domain;

import lombok.Data;

import java.util.List;

@Data
public class SituacaoCliente {

    private DadosCLiente cliente;
    private List<CartaoCliente> cartoes;

}
