package fr.tlse.m1miage.ea.procrastinapp.rest_api.responses;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.NiveauDifficulte;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.StatutDefiProcrastination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefiProcrastinationResponseDTO {
    private Boolean creationReussie;
    private Long id;
    private String titre;
    private String description;
    private Double duree;
    private NiveauDifficulte difficulte;
    private Integer pointsAGagner;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private StatutDefiProcrastination statut;
    private UtilisateurResponseDTO createur;
}
