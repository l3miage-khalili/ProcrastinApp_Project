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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * OneToOne ?? type => int ?
     */
    @Column(nullable = false)
    private Long idPiege;

    /**
     * OneToOne ?? type => int ?
     */
    @Column(nullable = false)
    private Long idUtilisateur;

    private LocalDate dateConfrontation;

    @Enumerated(EnumType.STRING)
    private ResultatConfrontationPiege resultat;

    private Integer points;
    private String commentaireUtilisateur;
}
