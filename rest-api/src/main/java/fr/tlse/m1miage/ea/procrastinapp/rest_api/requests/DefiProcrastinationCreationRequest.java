package fr.tlse.m1miage.ea.procrastinapp.rest_api.requests;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.NiveauDifficulte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefiProcrastinationCreationRequest {
    private Long id;
    private Long idCreateur;
    private String titre;
    private String description;
    private Double duree;
    private NiveauDifficulte difficulte;
    private Integer pointsAGagner;
    private LocalDate dateDebut;
    private LocalDate dateFin;
}
