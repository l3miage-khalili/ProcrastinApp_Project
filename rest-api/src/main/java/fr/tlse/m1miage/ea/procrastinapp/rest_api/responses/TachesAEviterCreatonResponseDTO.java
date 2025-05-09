package fr.tlse.m1miage.ea.procrastinapp.rest_api.responses;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class TachesAEviterCreatonResponseDTO {
    // indique si les taches ont ete creees avec succes ou pas
    private boolean creationReussie;

    // message d'echec ou de succes
    private String message;

    public TachesAEviterCreatonResponseDTO(boolean creationReussie, String message){
        this.creationReussie = creationReussie;
        this.message = message;
    }
}
