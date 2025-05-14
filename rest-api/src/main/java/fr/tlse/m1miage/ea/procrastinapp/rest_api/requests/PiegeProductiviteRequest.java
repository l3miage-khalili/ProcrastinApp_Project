package fr.tlse.m1miage.ea.procrastinapp.rest_api.requests;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.NiveauDifficulte;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.StatutPiegeProductivite;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.TypePiegeProductivite;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PiegeProductiviteRequest {
    private long id;
    private String titre;
    private String description;
    private TypePiegeProductivite typePiegeProductivite;
    private NiveauDifficulte niveauDifficulte;
    private Integer recompenseResistance;
    private Integer consequenceEchec;
    private StatutPiegeProductivite statut;
    private long createur;
}
