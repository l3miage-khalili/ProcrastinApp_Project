package fr.tlse.m1miage.ea.procrastinapp.rest_api.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TachesAEviterCreationRequest {
    private Long idUtilisateur;
    private List<TacheAEviterCreationRequest> taches;
}
