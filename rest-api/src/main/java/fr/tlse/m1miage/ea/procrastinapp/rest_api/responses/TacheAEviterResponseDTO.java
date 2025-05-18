package fr.tlse.m1miage.ea.procrastinapp.rest_api.responses;

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
public class TacheAEviterResponseDTO {
    private Long id;
    private String description;
    private Integer degreUrgence;
    private LocalDate dateLimite;
    private String consequencesPotentielles;
    private StatutTacheAEviter statut;
    private LocalDate dateCreation;
    private UtilisateurResponseDTO utilisateur;
}
