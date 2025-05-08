package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.CategorieExcuseCreative;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutExcuseCreative;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "excuses_creatives")
public class ExcuseCreativeEntity {
    @Id
    private Long id;  // A automatiser apres pour generer automatiquement les Id, pour le moment simple et pratique à tester sans l'automatisation

    private String texteExcuse;
    private String situationApplication;
    private Integer votesRecus;
    private Long auteur;
    private LocalDate dateSoumission;

    @Enumerated(EnumType.STRING)
    private CategorieExcuseCreative categorie;

    @Enumerated(EnumType.STRING)
    private StatutExcuseCreative statut;
    /**
     * une excuse créative esr créer par un seul utilisateur
     * creer une classe (table) qui fait le lien entre les votes et les excuses?
     *
     */
    @ManyToOne
    private UtilisateurEntity utilisateurEntity;
}
