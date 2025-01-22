package br.com.gestao_eventos.gestao_eventos.modules.empresa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestao_eventos.gestao_eventos.modules.empresa.entities.EventoEntity;

public interface EventoRepository extends JpaRepository<EventoEntity, UUID>{
    
}
