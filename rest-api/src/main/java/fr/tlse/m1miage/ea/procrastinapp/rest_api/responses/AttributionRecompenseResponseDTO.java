package fr.tlse.m1miage.ea.procrastinapp.rest_api.responses;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.StatutAttributionRecompense;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttributionRecompenseResponseDTO {
    private Long id;
    private LocalDate dateObtention;
    private LocalDate dateExpiration;
    private String contexteAttribution;
    private StatutAttributionRecompense statut;
    private RecompenseResponseDTO recompense;
    private UtilisateurResponseDTO utilisateur;
}
