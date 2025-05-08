package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutParticipationDefi;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "participations_defis")
public class ParticipationDefiEntity {
    @Id
    private Long id;  // A automatiser apres pour generer automatiquement les Id, pour le moment simple et pratique à tester sans l'automatisation

    @ManyToOne
    private DefiProcrastinationEntity defi;

    @ManyToOne
    private UtilisateurEntity utilisateur;

    private LocalDate dateInscription;

    @Enumerated(EnumType.STRING)
    private StatutParticipationDefi statut;

    private Integer pointsGagnes;
}
