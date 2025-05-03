package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutAttributionRecompense;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "attributions_recompenses")
public class AttributionRecompenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * OneToOne ?? type => int ?
     */
    @Column(nullable = false)
    private Long idRecompense;
    /**
     * OneToOne ?? type => int ?
     */
    @Column(nullable = false)
    private Long idUtilisateur;

    private LocalDate dateObtention;
    private LocalDate dateExpiration;
    private String contexteAttribution;

    @Enumerated(EnumType.STRING)
    private StatutAttributionRecompense statut;
}
