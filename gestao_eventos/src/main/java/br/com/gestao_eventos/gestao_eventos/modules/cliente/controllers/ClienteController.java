package br.com.gestao_eventos.gestao_eventos.modules.cliente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestao_eventos.gestao_eventos.exceptions.UserFoundException;
import br.com.gestao_eventos.gestao_eventos.modules.cliente.ClienteEntity;
import br.com.gestao_eventos.gestao_eventos.modules.cliente.ClienteRepository;
import br.com.gestao_eventos.gestao_eventos.modules.cliente.useCases.CreateClienteUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private CreateClienteUseCase createClienteUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody ClienteEntity clienteEntity) {
        try {
            var result = this.createClienteUseCase.execute(clienteEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
