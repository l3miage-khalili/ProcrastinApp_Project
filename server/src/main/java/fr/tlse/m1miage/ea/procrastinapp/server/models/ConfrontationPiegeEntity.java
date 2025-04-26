package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.ResultatConfrontationPiege;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "confrontations_pieges")
public class ConfrontationPiegeEntity {
    @Id
    private Long id;

    @Column(nullable = false)
    private Long idPiege;

    @Column(nullable = false)
    private Long idUtilisateur;

    private LocalDate dateConfrontation;

    @Enumerated(EnumType.STRING)
    private ResultatConfrontationPiege resultat;

    private Integer points;
    private String commentaireUtilisateur;
}
