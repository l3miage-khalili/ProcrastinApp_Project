package fr.tlse.m1miage.ea.procrastinapp.rest_api.requests;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.StatutTacheAEviter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TacheAEviterUpdatingRequest {
    private String description;
    private Integer degreUrgence;
    private String consequencesPotentielles;
    private StatutTacheAEviter statut;
}
