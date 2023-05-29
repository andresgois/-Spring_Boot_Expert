package io.github.andresgois.msavaliadorcredito.service;

import io.github.andresgois.msavaliadorcredito.domain.DadosCLiente;
import io.github.andresgois.msavaliadorcredito.domain.SituacaoCliente;
import io.github.andresgois.msavaliadorcredito.infra.clients.ClienteResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResourceClient clienteResourceClient;

    public SituacaoCliente obterSituacaoCliente(String cpf) {
        // obter dados do cliente
        ResponseEntity<DadosCLiente> dadosClientesResponse = clienteResourceClient.buscarPorCpf(cpf);
        // obter cartões do cliente
        return SituacaoCliente
                .builder()
                .cliente(dadosClientesResponse.getBody())
                .build();
    }
}
