package io.github.andresgois.msavaliadorcredito.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("avaliacoes-credito")
public class AvaliadorCredito {

    @GetMapping
    public String status(){
        return "ok";
    }
}
