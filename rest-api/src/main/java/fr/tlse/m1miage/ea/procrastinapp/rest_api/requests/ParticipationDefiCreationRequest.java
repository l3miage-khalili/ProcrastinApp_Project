package fr.tlse.m1miage.ea.procrastinapp.rest_api.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipationDefiCreationRequest {
    private Long id;
    private Long idDefi;
    private Long idUtilisateur;
}
