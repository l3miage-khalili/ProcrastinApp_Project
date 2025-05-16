package fr.tlse.m1miage.ea.procrastinapp.rest_api.requests;

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
public class ConfrontationPiegeCreationRequest {
    private Long id;
    private Long idPiege;
    private Long idUtilisateur;
    private ResultatConfrontationPiege resultat;
    private String commentaireUtilisateur;
}
