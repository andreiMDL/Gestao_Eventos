package br.com.gestao_eventos.gestao_eventos.modules.empresa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity(name = "evento")
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Insira uma opção válida: [CASAMENTO, ANIVERSARIO, NOIVADO, CHURRASCO, FESTA_FORMATURA, FESTA_QUINZE_ANOS, HAPPY_HOUR]")
    private EventType tipoEvento;

    public enum EventType {
        CASAMENTO,
        ANIVERSARIO,
        NOIVADO,
        CHURRASCO,
        FESTA_FORMATURA,
        FESTA_QUINZE_ANOS,
        HAPPY_HOUR
    }

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Insira uma opção válida: [CHURRASCO, PIZZAS, HAMBURGUERES, SUSHI, FRIOS, SORVETES, BEBIDAS_ALCOOLICAS, BEBIDAS_NAO_ALCOOLICAS, COMPLETO]")
    private BuffetType tipoBuffet;

    public enum BuffetType {
        CHURRASCO,
        PIZZAS,
        BEBIDAS_ALCOOLICAS,
        BEBIDAS_NAO_ALCOOLICAS,
        HAMBURGUERES,
        SUSHI,
        SORVETES,
        FRIOS,
        COMPLETO
    }

    @NotBlank
    private String location;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
