package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutTacheAEviter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "taches_a_eviter")
public class TacheAEviterEntity {
    @Id
    private Long id;  // A automatiser apres pour generer automatiquement les Id, pour le moment simple et pratique à tester sans l'automatisation

    private String description;

    @NotNull
    private Integer degreUrgence;

    @NotNull
    private LocalDate dateLimite;

    private String consequencesPotentielles;

    @Enumerated(EnumType.STRING)
    private StatutTacheAEviter statut;

    private LocalDate dateCreation;

    @NotNull
    @ManyToOne
    private UtilisateurEntity utilisateurEntity;
}
