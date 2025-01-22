package br.com.gestao_eventos.gestao_eventos.modules.cliente.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestao_eventos.gestao_eventos.modules.cliente.entities.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID>{
    Optional<ClienteEntity> findByCpfOrEmail(String cpf, String email); 
}
