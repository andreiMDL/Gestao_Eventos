package br.com.gestao_eventos.gestao_eventos.modules.empresa.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "evento")
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Enumerated(EnumType.STRING)
    @NotNull(message = "Insira uma opção válida: [CASAMENTO, ANIVERSARIO, NOIVADO, CHURRASCO, FESTA_FORMATURA, FESTA_QUINZE_ANOS, HAPPY_HOUR]")
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
    @NotNull(message = "Insira uma opção válida: [CHURRASCO, PIZZAS, HAMBURGUERES, SUSHI, FRIOS, SORVETES, BEBIDAS_ALCOOLICAS, BEBIDAS_NAO_ALCOOLICAS, COMPLETO]")
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

    @NotBlank(message = "O campo [location] não pode ser vazio")
    private String location;

    @NotNull(message = "O campo [data] não pode ser vazio")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @NotNull(message = "O campo [horario] não pode ser vazio")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime horario;
    
    @ManyToOne()
    @JoinColumn(name = "empresa_id", nullable = false, updatable = false)
    private EmpresaEntity empresaEntity;


    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
