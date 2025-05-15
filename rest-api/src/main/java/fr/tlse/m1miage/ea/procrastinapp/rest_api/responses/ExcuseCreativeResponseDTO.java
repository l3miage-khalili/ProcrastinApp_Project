package fr.tlse.m1miage.ea.procrastinapp.rest_api.responses;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.CategorieExcuseCreative;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.StatutExcuseCreative;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ExcuseCreativeResponseDTO {
    private Long id;  // A automatiser apres pour generer automatiquement les Id, pour le moment simple et pratique à tester sans l'automatisation
    private String texteExcuse;
    private String situationApplication;
    private Integer votesRecus;
    private LocalDate dateSoumission;
    private CategorieExcuseCreative categorie;
    private StatutExcuseCreative statut;
    private Long auteur;
}
