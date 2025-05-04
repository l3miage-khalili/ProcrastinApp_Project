package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutTacheAEviter;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "taches_a_eviter")
public class TacheAEviterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
