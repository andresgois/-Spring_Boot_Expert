package io.gtihub.andresgois.rest.controller;

import io.gtihub.andresgois.domain.entity.Cliente;
import io.gtihub.andresgois.domain.repository.IClientesRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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

    @PostMapping
    @ResponseBody
    public ResponseEntity<Cliente> save(@RequestBody @Valid Cliente c){
        Cliente cliente = cliRepository.save(c);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Optional<Cliente> cliente = cliRepository.findById(id);
        if(cliente.isPresent()){
            cliRepository.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Valid Cliente cli){
        return cliRepository
                .findById(id)
                .map( clienteAtualizado -> {
                    cli.setId(clienteAtualizado.getId());
                    cliRepository.save(cli);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @GetMapping
    public ResponseEntity<?> find(Cliente filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING
                );
        Example example = Example.of(filtro, matcher);
        List<Cliente> lista = cliRepository.findAll(example);
        return ResponseEntity.ok(lista);
    }

}
