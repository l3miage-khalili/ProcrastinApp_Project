package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.CategorieExcuseCreative;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutExcuseCreative;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "excuses_creatives")
public class ExcuseCreativeEntity {
    @Id
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

    @ManyToOne
    private UtilisateurEntity utilisateurEntity;
}
