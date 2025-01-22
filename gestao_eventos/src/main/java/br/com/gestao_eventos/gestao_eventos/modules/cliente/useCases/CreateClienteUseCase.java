package br.com.gestao_eventos.gestao_eventos.modules.cliente.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestao_eventos.gestao_eventos.exceptions.UserFoundException;
import br.com.gestao_eventos.gestao_eventos.modules.cliente.ClienteEntity;
import br.com.gestao_eventos.gestao_eventos.modules.cliente.ClienteRepository;

@Service
public class CreateClienteUseCase {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity execute(ClienteEntity clienteEntity) {
        this.clienteRepository.findByCpfOrEmail(clienteEntity.getCpf(), clienteEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.clienteRepository.save(clienteEntity);
    }

}
