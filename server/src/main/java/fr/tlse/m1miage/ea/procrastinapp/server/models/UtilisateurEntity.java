package fr.tlse.m1miage.ea.procrastinapp.server.models;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.NiveauProcrastination;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "utilisateurs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pseudo;

    @Column(nullable = false, unique = true)
    private String adresseEmail;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDate dateInscription;

    @Enumerated(EnumType.STRING)
    private NiveauProcrastination niveauProcrastination;

    private String excusePreferee;
    private Integer pointsAccumules;

    @OneToMany(mappedBy = "utilisateurEntity")
    private Set<TacheAEviterEntity> tacheAEviterEntities;

    @OneToMany(mappedBy = "utilisateurEntity")
    private Set<ExcuseCreativeEntity> excuseCreativeEntities;

    @OneToMany(mappedBy = "utilisateurEntity")
    private Set<PiegeProductiviteEntity> piegeProductiviteEntities;

    //relation entre gestionnaire et defis créés
    @OneToMany(mappedBy = "utilisateurEntity")
    private Set<DefiProcrastinationEntity> defiProcrastinationEntities;

    //relation entre procrastinateur et defis jouer
    @OneToMany(mappedBy = "utilisateur")
    private Set<ParticipationDefiEntity> participationDefiEntities;

    @ManyToOne
    private UtilisateurEntity gestionnaire;

    @OneToMany(mappedBy = "gestionnaire")
    private Set<UtilisateurEntity> antiProcrastinateurs;

    @OneToMany(mappedBy = "utilisateur")
    private Set<AttributionRecompenseEntity> attributionRecompenses;

    @OneToMany(mappedBy = "utilisateur")
    private Set<ConfrontationPiegeEntity> confrontationPieges;


}
