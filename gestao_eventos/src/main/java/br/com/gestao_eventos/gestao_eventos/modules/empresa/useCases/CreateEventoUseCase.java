package br.com.gestao_eventos.gestao_eventos.modules.empresa.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestao_eventos.gestao_eventos.modules.empresa.entities.EventoEntity;
import br.com.gestao_eventos.gestao_eventos.modules.empresa.repositories.EventoRepository;

@Service
public class CreateEventoUseCase {
    
    @Autowired
    private EventoRepository eventoRepository;

    public EventoEntity execute(EventoEntity eventoEntity){
        return this.eventoRepository.save(eventoEntity);
    }
}
