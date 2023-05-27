package io.github.andresgois.msclientes.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
public class ClienteResource {

    @GetMapping
    public String status(){
        return "ok";
    }
}
