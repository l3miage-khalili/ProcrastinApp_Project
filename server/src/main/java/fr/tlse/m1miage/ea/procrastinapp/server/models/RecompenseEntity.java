package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.TypeRecompense;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "recompenses")
public class RecompenseEntity {
    @Id
    private Long id;
    private String titre;
    private String description;
    private String conditionsObtention;

    @Min(1)
    @Max(5)
    private Integer niveauPrestige;

    @Enumerated(EnumType.STRING)
    private TypeRecompense type;
}
