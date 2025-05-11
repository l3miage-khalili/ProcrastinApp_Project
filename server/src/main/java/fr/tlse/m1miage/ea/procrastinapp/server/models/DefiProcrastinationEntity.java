package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.NiveauDifficulte;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutDefiProcrastination;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "defis_procrastination")
public class DefiProcrastinationEntity {
    @Id
    private Long id;  // A automatiser apres pour generer automatiquement les Id, pour le moment simple et pratique à tester sans l'automatisation

    private String titre;

    @NotNull
    private String description;

    private Double duree;

    @Enumerated(EnumType.STRING)
    private NiveauDifficulte difficulte;

    @NotNull
    private Integer pointsAGagner;

    @NotNull
    private LocalDate dateDebut;

    @NotNull
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private StatutDefiProcrastination statut;

    @OneToMany(mappedBy = "defi")
    private Set<ParticipationDefiEntity> participations;

    //utilisateur => Gestionnaire
    @ManyToOne
    @NotNull
    private UtilisateurEntity utilisateurEntity;
}
