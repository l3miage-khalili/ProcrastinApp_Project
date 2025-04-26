package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutParticipationDefi;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "participations_defis")
public class ParticipationDefiEntity {
    @Id
    private Long id;

    @Column(nullable = false)
    private Long idDefi;

    @Column(nullable = false)
    private Long idUtilisateur;

    private LocalDate dateInscription;

    @Enumerated(EnumType.STRING)
    private StatutParticipationDefi statut;

    private Integer pointsGagnes;
}
