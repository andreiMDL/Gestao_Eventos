package br.com.gestao_eventos.gestao_eventos.modules.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestao_eventos.gestao_eventos.modules.cliente.ClienteRepository;
import br.com.gestao_eventos.gestao_eventos.modules.empresa.EmpresaEntity;
import br.com.gestao_eventos.gestao_eventos.modules.empresa.EmpresaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

      @Autowired
      private EmpresaRepository empresaRepository;

      @PostMapping("/")
      public EmpresaEntity create(@Valid @RequestBody EmpresaEntity empresaEntity) {
            return this.empresaRepository.save(empresaEntity);
      }
}
