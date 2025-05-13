package fr.tlse.m1miage.ea.procrastinapp.rest_api.responses;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.NiveauProcrastination;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurResponseDTO {
    private Boolean inscriptionReussie ;    /* indique si l'utilisateur a été créé avec succès ou pas */
    private String message;                 /* message d'échec ou de succès */
    private Long id;
    private String pseudo;
    private String adresseEmail;
    private Role role;
    private NiveauProcrastination niveauProcrastination;
    private String excusePreferee;
    private LocalDate dateInscription;
    private Integer pointsAccumules;
}
