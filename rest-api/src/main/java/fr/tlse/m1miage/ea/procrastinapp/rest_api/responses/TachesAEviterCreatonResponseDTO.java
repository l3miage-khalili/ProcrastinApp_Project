package fr.tlse.m1miage.ea.procrastinapp.rest_api.responses;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class TachesAEviterCreatonResponseDTO {
    // indique si les taches ont été créées avec succès ou pas
    private boolean creationReussie;

    // message d'échec ou de succès
    private String message;

    public TachesAEviterCreatonResponseDTO(boolean creationReussie, String message){
        this.creationReussie = creationReussie;
        this.message = message;
    }
}
