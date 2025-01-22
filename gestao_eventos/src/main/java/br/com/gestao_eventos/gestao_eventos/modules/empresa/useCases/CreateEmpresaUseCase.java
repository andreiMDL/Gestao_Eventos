package br.com.gestao_eventos.gestao_eventos.modules.empresa.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestao_eventos.gestao_eventos.exceptions.UserFoundException;
import br.com.gestao_eventos.gestao_eventos.modules.cliente.entities.ClienteEntity;
import br.com.gestao_eventos.gestao_eventos.modules.cliente.repositories.ClienteRepository;
import br.com.gestao_eventos.gestao_eventos.modules.empresa.entities.EmpresaEntity;
import br.com.gestao_eventos.gestao_eventos.modules.empresa.repositories.EmpresaRepository;

@Service
public class CreateEmpresaUseCase {
    
    @Autowired
    private EmpresaRepository empresaRepository;
    
    public EmpresaEntity execute(EmpresaEntity empresaEntity) {
        this.empresaRepository.findByCnpjOrEmail(empresaEntity.getCnpj(), empresaEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.empresaRepository.save(empresaEntity);
    }

}
