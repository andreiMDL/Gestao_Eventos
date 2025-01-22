package br.com.gestao_eventos.gestao_eventos.modules.cliente;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID>{
    ClienteEntity findByUsernameOrEmail(String username, String email);
}
