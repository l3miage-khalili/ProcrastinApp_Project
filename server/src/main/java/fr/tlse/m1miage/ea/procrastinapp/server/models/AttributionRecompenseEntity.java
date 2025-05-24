package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutAttributionRecompense;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attributions_recompenses")
public class AttributionRecompenseEntity {
    @Id
    private Long id;  // A automatiser apres pour generer automatiquement les Id, pour le moment simple et pratique à tester sans l'automatisation

    @NotNull
    @ManyToOne
    private RecompenseEntity recompense;

    @NotNull
    @ManyToOne
    private UtilisateurEntity utilisateur;

    private LocalDate dateObtention;
    private LocalDate dateExpiration;
    private String contexteAttribution;

    @Enumerated(EnumType.STRING)
    private StatutAttributionRecompense statut;
}
