package fr.tlse.m1miage.ea.procrastinapp.rest_api.responses;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.ResultatConfrontationPiege;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfrontationPiegeResponseDTO {
    private Long id;
    private LocalDate dateConfrontation;
    private ResultatConfrontationPiege resultat;
    private Integer points;
    private String commentaireUtilisateur;
    private PiegeProductiviteResponseDTO piege;
    private UtilisateurResponseDTO utilisateur;
}
