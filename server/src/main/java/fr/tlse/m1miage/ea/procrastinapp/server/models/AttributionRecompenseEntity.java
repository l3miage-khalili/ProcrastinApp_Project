package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutAttributionRecompense;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "attributions_recompenses")
public class AttributionRecompenseEntity {
    @Id
    private Long id;

    @Column(nullable = false)
    private Long idRecompense;

    @Column(nullable = false)
    private Long idUtilisateur;

    private LocalDate dateObtention;
    private LocalDate dateExpiration;
    private String contexteAttribution;

    @Enumerated(EnumType.STRING)
    private StatutAttributionRecompense statut;
}
