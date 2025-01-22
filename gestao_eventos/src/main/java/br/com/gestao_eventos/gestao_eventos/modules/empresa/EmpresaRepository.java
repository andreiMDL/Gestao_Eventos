package br.com.gestao_eventos.gestao_eventos.modules.empresa;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, UUID>{
    Optional<EmpresaEntity> findByCnpjOrEmail(String cnpj, String email);
}
    