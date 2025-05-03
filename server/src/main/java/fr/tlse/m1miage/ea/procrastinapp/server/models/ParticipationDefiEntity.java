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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * OneToOne ?? type => int ?
     */
    @Column(nullable = false)
    private Long idDefi;
    /**
     * OneToOne ?? type => int ?
     */
    @Column(nullable = false)
    private Long idUtilisateur;

    private LocalDate dateInscription;

    @Enumerated(EnumType.STRING)
    private StatutParticipationDefi statut;

    private Integer pointsGagnes;
}
