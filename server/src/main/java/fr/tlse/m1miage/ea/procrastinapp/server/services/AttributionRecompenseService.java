package fr.tlse.m1miage.ea.procrastinapp.server.services;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.AttributionRecompenseCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.AttributionRecompenseResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.RecompenseResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.UtilisateurResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.components.AttributionRecompenseComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.components.RecompenseComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.components.UtilisateurComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.NiveauPrestige;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.Role;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutAttributionRecompense;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.BadRequestRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.CreationFailedRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.ForbiddenRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.NotFoundRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.AttributionRecompenseMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.RecompenseMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.UtilisateurMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.models.AttributionRecompenseEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.models.RecompenseEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.models.UtilisateurEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class AttributionRecompenseService {

    private final AttributionRecompenseComponent attributionRecompenseComponent;
    private final AttributionRecompenseMapper attributionRecompenseMapper;
    private final RecompenseComponent recompenseComponent;
    private final RecompenseMapper recompenseMapper;
    private final UtilisateurComponent utilisateurComponent;
    private final UtilisateurMapper utilisateurMapper;

    public AttributionRecompenseResponseDTO createAttributionRecompense(AttributionRecompenseCreationRequest request) {
        try {
            UtilisateurEntity utilisateur = utilisateurComponent.getUtilisateurById(request.getIdUtilisateur());
            RecompenseEntity recompense = recompenseComponent.getRecompenseById(request.getIdRecompense());
            // on vérifie si l'utilisateur est bien un procrastinateur
            if (utilisateur.getRole() != Role.PROCRASTINATEUR_EN_HERBE){
                throw new ForbiddenRestException("Une récompense n'est attribuée qu'à un procrastinateur");
            }
            else {
                /* implémentation de la règle métier liée à la récompense de niveau OR */
                if (recompense.getNiveauPrestige() == NiveauPrestige.OR){
                    LocalDate dateInscriptionUtilisateur = utilisateur.getDateInscription();
                    int moisAnciennete = (int) ChronoUnit.MONTHS.between(dateInscriptionUtilisateur, LocalDate.now());
                    int pointsUtilisateur = utilisateur.getPointsAccumules();
                    if (moisAnciennete < 6 || pointsUtilisateur < 2000){
                        throw new ForbiddenRestException("Les récompenses de niveau OR ne peuvent être attribuées qu'aux utilisateurs ayant au moins 6 mois d'ancienneté dans l'application et un minimum de 2000 points accumulés");
                    }
                }
                AttributionRecompenseEntity entityFromRequest = attributionRecompenseMapper.creationRequestToEntity(request);
                /* complétion des champs de l'entité */
                entityFromRequest.setUtilisateur(utilisateur);
                entityFromRequest.setRecompense(recompense);
                entityFromRequest.setDateObtention(LocalDate.now());
                entityFromRequest.setStatut(StatutAttributionRecompense.ACTIF);
                // Enregistrement de l'entité dans la base
                AttributionRecompenseEntity savedEntity = attributionRecompenseComponent.createAttributionRecompense(entityFromRequest);
                // configuration de la réponse DTO
                AttributionRecompenseResponseDTO responseDTO = attributionRecompenseMapper.entityToResponseDTO(savedEntity);
                UtilisateurResponseDTO utilisateurDTO = utilisateurMapper.entityToResponseDTO(utilisateur);
                RecompenseResponseDTO recompenseDTO = recompenseMapper.entityToResponseDTO(recompense);
                responseDTO.setUtilisateur(utilisateurDTO);
                responseDTO.setRecompense(recompenseDTO);
                return responseDTO;
            }
        }
        catch (EntiteNotFoundException | NotFoundRestException e){
            throw new NotFoundRestException(e.getMessage());
        }
        catch (ForbiddenRestException e){
            throw new ForbiddenRestException(e.getMessage());
        }
        catch (BadRequestRestException e){
            throw new BadRequestRestException(e.getMessage());
        }
        catch (CreationFailedRestException e){
            throw new CreationFailedRestException(e.getMessage());
        }
    }
}
