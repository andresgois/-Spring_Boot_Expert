package io.gtihub.andresgois.rest.controller;

import io.gtihub.andresgois.domain.entity.Cliente;
import io.gtihub.andresgois.domain.repository.IClientesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    private IClientesRepository cliRepository;

    public ClienteController(IClientesRepository cliRepository) {
        this.cliRepository = cliRepository;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> helloCliente(@PathVariable("id") Integer id){
        Optional<Cliente> cliente = cliRepository.findById(id);
        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

}
