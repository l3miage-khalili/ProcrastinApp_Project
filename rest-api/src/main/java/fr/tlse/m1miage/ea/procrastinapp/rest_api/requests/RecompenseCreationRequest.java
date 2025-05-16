package fr.tlse.m1miage.ea.procrastinapp.rest_api.requests;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.NiveauPrestige;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.TypeRecompense;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecompenseCreationRequest {
    private Long id;
    private String titre;
    private String description;
    private String conditionsObtention;
    private NiveauPrestige niveauPrestige;
    private TypeRecompense type;
}
