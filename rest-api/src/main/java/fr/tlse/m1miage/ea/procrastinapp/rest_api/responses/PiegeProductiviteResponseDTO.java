package fr.tlse.m1miage.ea.procrastinapp.rest_api.responses;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.NiveauDifficulte;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.StatutPiegeProductivite;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.TypePiegeProductivite;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PiegeProductiviteResponseDTO {
    private int id;
    private String titre;
    private String description;
    private TypePiegeProductivite typePiegeProductivite;
    private Long createur;
    private NiveauDifficulte niveauDifficulte;
    private Integer recompenseResistance;
    private Integer consequenceEchec;
    private StatutPiegeProductivite statut;
}
