package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.ResultatConfrontationPiege;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "confrontations_pieges")
public class ConfrontationPiegeEntity {
    @Id
    private Long id;  // A automatiser apres pour generer automatiquement les Id, pour le moment simple et pratique à tester sans l'automatisation

    @ManyToOne
    private PiegeProductiviteEntity piege;

    @ManyToOne
    private UtilisateurEntity utilisateur;

    private LocalDate dateConfrontation;

    @Enumerated(EnumType.STRING)
    private ResultatConfrontationPiege resultat;

    private Integer points;
    private String commentaireUtilisateur;
}
