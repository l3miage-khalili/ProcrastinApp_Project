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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
