package br.com.gestao_eventos.gestao_eventos.modules.empresa.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestao_eventos.gestao_eventos.modules.empresa.entities.EmpresaEntity;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, UUID>{
    Optional<EmpresaEntity> findByCnpjOrEmail(String cnpj, String email);
}
    