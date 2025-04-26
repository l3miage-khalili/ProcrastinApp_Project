package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.NiveauDifficulte;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutDefiProcrastination;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "defis_procrastination")
public class DefiProcrastinationEntity {
    @Id
    private Long id;
    private String titre;
    private String description;
    private Double duree;

    @Enumerated(EnumType.STRING)
    private NiveauDifficulte difficulte;

    private Integer pointsAGagner;
    private Long createur;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private StatutDefiProcrastination statut;
}
