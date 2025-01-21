package br.com.gestao_eventos.gestao_eventos.modules.cliente;

import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ClienteEntity {
    
    private String name;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{8,}$",
        message = "A senha deve ter no mínimo 8 caracteres, incluindo letras maiúsculas, minúsculas, números e pelo menos um caracter especial.")
    private String password;

    @CPF(message = "O campo deve conter um CPF válido")
    private String cpf;

    @Email(message = "O campo deve conter um email válido")
    private String email;

    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Número de telefone inválido")
    private String telefone;

    private UUID id;
}
