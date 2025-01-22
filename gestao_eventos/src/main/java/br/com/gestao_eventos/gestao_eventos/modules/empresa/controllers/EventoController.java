package br.com.gestao_eventos.gestao_eventos.modules.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestao_eventos.gestao_eventos.modules.empresa.entities.EventoEntity;
import br.com.gestao_eventos.gestao_eventos.modules.empresa.useCases.CreateEventoUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/evento")
public class EventoController {

      @Autowired
      private CreateEventoUseCase createEventoUseCase;

      @PostMapping("/")
      public EventoEntity create(@Valid @RequestBody EventoEntity eventoEntity) {
            return this.createEventoUseCase.execute(eventoEntity);
      }
}
