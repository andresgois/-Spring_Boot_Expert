package io.github.andresgois.mscartoes.service;

import io.github.andresgois.mscartoes.domain.ClienteCartao;
import io.github.andresgois.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository repository;

    public List<ClienteCartao> listCartoesPorCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
