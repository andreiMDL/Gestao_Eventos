package br.com.gestao_eventos.gestao_eventos.modules.cliente;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID>{
    Optional<ClienteEntity> findByCpfOrEmail(String cpf, String email); 
}
