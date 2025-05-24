package fr.tlse.m1miage.ea.procrastinapp.rest_api.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttributionRecompenseCreationRequest {
    private Long id;
    private Long idUtilisateur;
    private Long idRecompense;
    private LocalDate dateExpiration;
    private String contexteAttribution;
}
