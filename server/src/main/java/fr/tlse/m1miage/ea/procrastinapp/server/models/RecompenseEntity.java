package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.NiveauPrestige;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.TypeRecompense;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "recompenses")
public class RecompenseEntity {
    @Id
    private Long id;  // A automatiser apres pour generer automatiquement les Id, pour le moment simple et pratique à tester sans l'automatisation

    @NotNull
    private String titre;

    private String description;
    private String conditionsObtention;
    private NiveauPrestige niveauPrestige;

    @Enumerated(EnumType.STRING)
    private TypeRecompense type;

    @OneToMany(mappedBy = "recompense")
    private Set<AttributionRecompenseEntity> attributions;
}
