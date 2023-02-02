package io.gtihub.andresgois.rest.controller;

import io.gtihub.andresgois.domain.entity.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientControl {
    @RequestMapping(
            value = { "/api/clientes/hello/{nome} ", "/api/hello"},
            method = RequestMethod.GET,
            consumes = { "application/json", "application/xml"},
            produces = { "application/json", "application/xml"}
    )
    @ResponseBody
    public Cliente helloCliente(
            @PathVariable("nome") String nome,
            @RequestBody Cliente cliente
    ){
        return null;
    }
}
