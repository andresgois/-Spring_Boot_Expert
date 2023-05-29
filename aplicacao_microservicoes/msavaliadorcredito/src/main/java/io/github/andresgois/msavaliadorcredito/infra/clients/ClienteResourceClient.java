package io.github.andresgois.msavaliadorcredito.infra.clients;

import io.github.andresgois.msavaliadorcredito.domain.DadosCLiente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(url = "http://localhost:8080", path = "/clientes")
@FeignClient(value = "msclient", path = "/clientes")
public interface ClienteResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<DadosCLiente> buscarPorCpf(@RequestParam("cpf") String cpf);

}
