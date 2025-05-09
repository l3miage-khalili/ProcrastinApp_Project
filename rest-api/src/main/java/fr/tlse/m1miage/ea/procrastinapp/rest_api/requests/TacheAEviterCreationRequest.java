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
public class TacheAEviterCreationRequest {
    private Long id;
    private String description;
    private Integer degreUrgence;
    private LocalDate dateLimite;
    private String consequencesPotentielles;
}
