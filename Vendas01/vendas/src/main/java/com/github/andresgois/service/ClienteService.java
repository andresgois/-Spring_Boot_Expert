package com.github.andresgois.service;

import com.github.andresgois.model.Cliente;
import com.github.andresgois.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    // Terceira forma
    // @Autowired
    // private ClienteRepository clienteRepository;

    // Segunda forma
    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public void salvaCliente(Cliente cliente){
        validarCliente(cliente);
        // primeira forma
        //ClienteRepository clienteRepository = new ClienteRepository();
        clienteRepository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){

    }
}
