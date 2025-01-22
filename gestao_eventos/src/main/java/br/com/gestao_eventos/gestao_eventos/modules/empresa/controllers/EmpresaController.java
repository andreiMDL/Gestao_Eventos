package br.com.gestao_eventos.gestao_eventos.modules.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestao_eventos.gestao_eventos.modules.cliente.repositories.ClienteRepository;
import br.com.gestao_eventos.gestao_eventos.modules.empresa.entities.EmpresaEntity;
import br.com.gestao_eventos.gestao_eventos.modules.empresa.repositories.EmpresaRepository;
import br.com.gestao_eventos.gestao_eventos.modules.empresa.useCases.CreateEmpresaUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

      @Autowired
      private CreateEmpresaUseCase createEmpresaUseCase;

      @PostMapping("/")
      public ResponseEntity<Object> create(@Valid @RequestBody EmpresaEntity empresaEntity) {
            try {
            var result = this.createEmpresaUseCase.execute(empresaEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
      }
}
