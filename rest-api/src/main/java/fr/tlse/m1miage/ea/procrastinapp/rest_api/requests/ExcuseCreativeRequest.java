package fr.tlse.m1miage.ea.procrastinapp.rest_api.requests;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.enums.CategorieExcuseCreative;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class ExcuseCreativeRequest {
    private Long id;
    private String texteExcuse;
    private String situationApplication;
    private Long auteur;
    private CategorieExcuseCreative categorie;
}
