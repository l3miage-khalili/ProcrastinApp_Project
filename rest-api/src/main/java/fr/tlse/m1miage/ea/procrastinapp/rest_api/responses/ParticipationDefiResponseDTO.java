package fr.tlse.m1miage.ea.procrastinapp.rest_api.responses;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.StatutParticipationDefi;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipationDefiResponseDTO {
    private Boolean creationReussie;    /* indique si la création a réussie */
    private String message;            /* message d'échec ou de succès */
    private Long id;
    private LocalDate dateInscription;
    private StatutParticipationDefi statut;
    private UtilisateurResponseDTO utilisateur;
    private DefiProcrastinationResponseDTO defi;
    private Integer pointsGagnes;
}
