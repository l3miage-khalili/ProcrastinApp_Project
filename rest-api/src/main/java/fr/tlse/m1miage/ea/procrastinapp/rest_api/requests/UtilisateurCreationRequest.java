package fr.tlse.m1miage.ea.procrastinapp.rest_api.requests;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.NiveauProcrastination;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurCreationRequest {
    private Long id;
    private String pseudo;
    private String adresseEmail;
    private Role role;
    private String excusePreferee;
}
