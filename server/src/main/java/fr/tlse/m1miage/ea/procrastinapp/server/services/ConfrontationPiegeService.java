package fr.tlse.m1miage.ea.procrastinapp.server.services;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.ConfrontationPiegeCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.ConfrontationPiegeResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.PiegeProductiviteResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.UtilisateurResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.components.*;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.NiveauProcrastination;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.ResultatConfrontationPiege;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.Role;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutAttributionRecompense;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.BadRequestRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.CreationFailedRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.ForbiddenRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.NotFoundRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.ConfrontationPiegeMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.PiegeProductiviteMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.UtilisateurMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ConfrontationPiegeService {

    private final ConfrontationPiegeComponent confrontationPiegeComponent;
    private final ConfrontationPiegeMapper confrontationPiegeMapper;
    private final PiegeProductiviteComponent piegeProductiviteComponent;
    private final PiegeProductiviteMapper piegeProductiviteMapper;
    private final UtilisateurComponent utilisateurComponent;
    private final UtilisateurMapper utilisateurMapper;
    private final AttributionRecompenseComponent attributionRecompenseComponent;
    private final RecompenseComponent recompenseComponent;

    public ConfrontationPiegeResponseDTO createConfrontationPiege(ConfrontationPiegeCreationRequest confrontationCreationRequest) throws
            BadRequestRestException {
        try {
            // récupération du piège
            Long idPiege = confrontationCreationRequest.getIdPiege();
            PiegeProductiviteEntity piege = piegeProductiviteComponent.getPiegeProductiviteById(idPiege);
            // récupération de l'utilisateur
            Long idUtilisateur = confrontationCreationRequest.getIdUtilisateur();
            UtilisateurEntity utilisateur = utilisateurComponent.getUtilisateurById(idUtilisateur);
            // on vérifie que l'utilisateur est bien un procrastinateur en herbe
            if (utilisateur.getRole() != Role.PROCRASTINATEUR_EN_HERBE){
                throw new BadRequestRestException("l'utilisateur doit avoir le rôle d'un procrastinateur en herbe pour confronter un piège");
            }
            else {
                int points = 50;
                ConfrontationPiegeEntity entityFromRequest = confrontationPiegeMapper.creationRequestToEntity(confrontationCreationRequest);
                entityFromRequest.setDateConfrontation(LocalDate.now());
                entityFromRequest.setPoints(points);
                if (entityFromRequest.getResultat() == ResultatConfrontationPiege.SUCCES){
                    // l'utilisateur gagne les points
                    utilisateur.setPointsAccumules(utilisateur.getPointsAccumules() + points);
                }
                else {
                    // l'utilisateur perd les points
                    utilisateur.setPointsAccumules(utilisateur.getPointsAccumules() - points);
                    /* gestion de la réception du badge */
                    // l'id de la nouvelle attribution de recompense
                    long idAttributionRecompense = attributionRecompenseComponent.getMaxId() + 1;
                    // récupération de la récompense à partir du titre qui est le badge
                    String badge = "Procrastinateur en Danger";
                    RecompenseEntity recompense = recompenseComponent.getRecompenseByTitre(badge);
                    LocalDate dateObtentionRecompense = entityFromRequest.getDateConfrontation();
                    // durée de la récompense
                    long dureeRecompense = 7;
                    LocalDate dateExpirationRecompense = dateObtentionRecompense.plusDays(dureeRecompense);
                    String contexteAttribution = String.format("utilisateur [%s] tombé dans le piège [%s] et devenu productif", idUtilisateur, idPiege);
                    // création de la récompense
                    AttributionRecompenseEntity attributionRecompense = AttributionRecompenseEntity
                            .builder()
                            .id(idAttributionRecompense)
                            .recompense(recompense)
                            .utilisateur(utilisateur)
                            .dateObtention(dateObtentionRecompense)
                            .dateExpiration(dateExpirationRecompense)
                            .contexteAttribution(contexteAttribution)
                            .statut(StatutAttributionRecompense.ACTIF)
                            .build();
                    attributionRecompenseComponent.createAttributionRecompense(attributionRecompense);

                }
                // on met à jour le niveau de procrastination de l'utilisateur après avoir modifié ses points accumulés
                int pointsAccumules = utilisateur.getPointsAccumules();
                if (pointsAccumules < 500){
                    utilisateur.setNiveauProcrastination(NiveauProcrastination.DEBUTANT);
                } else if (pointsAccumules < 1000) {
                    utilisateur.setNiveauProcrastination(NiveauProcrastination.INTERMEDIAIRE);
                }
                else {
                    utilisateur.setNiveauProcrastination(NiveauProcrastination.EXPERT);
                }
                UtilisateurEntity updatedUtilisateur = utilisateurComponent.updateUtilisateur(utilisateur);
                entityFromRequest.setUtilisateur(updatedUtilisateur);
                entityFromRequest.setPiege(piege);
                ConfrontationPiegeEntity savedConfrontationEntity = confrontationPiegeComponent.createConfrontationPiege(entityFromRequest);
                PiegeProductiviteResponseDTO piegeResponseDTO = piegeProductiviteMapper.entityToResponseDTO(piege);
                UtilisateurResponseDTO utilisateurResponseDTO = utilisateurMapper.entityToResponseDTO(utilisateur);
                ConfrontationPiegeResponseDTO responseDTO = confrontationPiegeMapper.entityToResponseDTO(savedConfrontationEntity);
                responseDTO.setPiege(piegeResponseDTO);
                responseDTO.setUtilisateur(utilisateurResponseDTO);
                return responseDTO;
            }
        }
        catch (EntiteNotFoundException e){
            throw new NotFoundRestException(e.getMessage());
        }
        catch (BadRequestRestException e){
            throw new BadRequestRestException(e.getMessage());
        }
        catch (CreationFailedRestException e){
            throw new CreationFailedRestException(e.getMessage());
        }
        catch (ForbiddenRestException e){
            throw new ForbiddenRestException(e.getMessage());
        }
    }
}
