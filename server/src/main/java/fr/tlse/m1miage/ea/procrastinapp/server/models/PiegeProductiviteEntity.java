package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.NiveauDifficulte;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutPiegeProductivite;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.TypePiegeProductivite;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "pieges_productivite")
public class PiegeProductiviteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private String description;

    @Enumerated(EnumType.STRING)
    private TypePiegeProductivite typePiegeProductivite;

    private Long createur;

    @Enumerated(EnumType.STRING)
    private NiveauDifficulte niveauDifficulte;

    private Integer recompenseResistance;
    private Integer consequenceEchec;
    private LocalDate dateCreation;

    @Enumerated(EnumType.STRING)
    private StatutPiegeProductivite statut;

    @ManyToOne
    private UtilisateurEntity utilisateurEntity;

    @OneToMany(mappedBy = "piege")
    private Set<ConfrontationPiegeEntity> confrontationPiegeEntities;
}
