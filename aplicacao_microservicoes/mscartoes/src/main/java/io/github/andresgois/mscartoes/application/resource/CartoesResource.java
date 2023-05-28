package io.github.andresgois.mscartoes.application.resource;

import io.github.andresgois.mscartoes.application.resource.representation.CartaoSaveRequest;
import io.github.andresgois.mscartoes.application.resource.representation.CartoesClienteResponse;
import io.github.andresgois.mscartoes.domain.Cartao;
import io.github.andresgois.mscartoes.domain.ClienteCartao;
import io.github.andresgois.mscartoes.service.CartaoService;
import io.github.andresgois.mscartoes.service.ClienteCartaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class CartoesResource {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CartaoSaveRequest request){
        Cartao cartao =  request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity buscarPorRenda(@RequestParam("renda") Long renda){
        List<Cartao> cartoes = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(cartoes);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesClienteResponse>> getCartoesPorCliente(
            @RequestParam("cpf") String cpf
    ){
        List<ClienteCartao> cartoes = clienteCartaoService.listCartoesPorCpf(cpf);
        List<CartoesClienteResponse> resultList = cartoes.stream()
                .map(CartoesClienteResponse::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }

}
