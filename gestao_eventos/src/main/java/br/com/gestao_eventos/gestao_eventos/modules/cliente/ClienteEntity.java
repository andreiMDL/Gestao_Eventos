package br.com.gestao_eventos.gestao_eventos.modules.cliente;

import java.util.UUID;

import lombok.Data;

@Data
public class ClienteEntity {
    
    private String name;
    private String password;
    private String cpf;
    private String email;
    private String telefone;
    private UUID id;
}
