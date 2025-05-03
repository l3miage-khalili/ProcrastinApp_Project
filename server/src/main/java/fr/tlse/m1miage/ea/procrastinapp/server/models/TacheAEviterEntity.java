package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutTacheAEviter;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "taches_a_eviter")
public class TacheAEviterEntity {
    @Id
    private Long id;

    @Column(nullable = false)
    private Long idUtilisateur;

    private String description;
    private Integer degreUrgence;
    private LocalDate dateLimite;
    private String consequencesPotentielles;

    @Enumerated(EnumType.STRING)
    private StatutTacheAEviter statut;

    private LocalDate dateCreation;

    @ManyToOne
    private UtilisateurEntity utilisateurEntity;
}
