package fr.tlse.m1miage.ea.procrastinapp.rest_api.requests;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.NiveauProcrastination;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurCreationRequest {
    private Long id;    // provisoirement demandé à l'utilisateur, sera automatisé dans la suite
    private String pseudo;
    private String adresseEmail;
    private Role role;
    private NiveauProcrastination niveauProcrastination;
    private String excusePreferee;
}
