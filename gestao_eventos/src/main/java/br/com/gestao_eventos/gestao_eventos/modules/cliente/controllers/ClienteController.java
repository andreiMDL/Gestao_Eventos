package br.com.gestao_eventos.gestao_eventos.modules.cliente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestao_eventos.gestao_eventos.modules.cliente.ClienteEntity;
import br.com.gestao_eventos.gestao_eventos.modules.cliente.ClienteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/")
    public ClienteEntity create(@Valid @RequestBody ClienteEntity clienteEntity) {
        return this.clienteRepository.save(clienteEntity);
    }
}
