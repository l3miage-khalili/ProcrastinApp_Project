package fr.tlse.m1miage.ea.procrastinapp.server.services;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.DefiProcrastinationCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.DefiProcrastinationResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.UtilisateurResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.components.DefiProcrastinationComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.components.UtilisateurComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.Role;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutDefiProcrastination;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.BadRequestRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.CreationFailedRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.ForbiddenRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.NotFoundRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.DefiProcrastinationMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.UtilisateurMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.models.DefiProcrastinationEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.models.UtilisateurEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class DefiProcrastinationService {

    private final DefiProcrastinationComponent defiProcrastinationComponent;
    private final DefiProcrastinationMapper defiProcrastinationMapper;
    private final UtilisateurComponent utilisateurComponent;
    private final UtilisateurMapper utilisateurMapper;

    public DefiProcrastinationResponseDTO createDefiProcrastination(DefiProcrastinationCreationRequest defiRequest) {
        try {
            UtilisateurEntity createurDefi = utilisateurComponent.getUtilisateurById(defiRequest.getIdCreateur());
            if (createurDefi.getRole() == Role.GESTIONNAIRE_TEMPS_PERDU){
                DefiProcrastinationEntity entityFromRequest = defiProcrastinationMapper.creationRequestToEntity(defiRequest);
                entityFromRequest.setStatut(StatutDefiProcrastination.ACTIF);
                entityFromRequest.setUtilisateurEntity(createurDefi);
                DefiProcrastinationEntity savedEntity = defiProcrastinationComponent.createDefiProcrastination(entityFromRequest);
                DefiProcrastinationResponseDTO responseDTO = defiProcrastinationMapper.entityToResponseDTO(savedEntity);
                UtilisateurResponseDTO utilisateurDTO = utilisateurMapper.entityToResponseDTO(createurDefi);
                utilisateurDTO.setInscriptionReussie(true);
                responseDTO.setCreateur(utilisateurDTO);
                responseDTO.setCreationReussie(true);
                responseDTO.setMessage("Le défi a été créé avec succès");
                return responseDTO;
            }
            else {
                // le créateur d'un défi de procrastination doit être un gestionnaire
                return DefiProcrastinationResponseDTO
                        .builder()
                        .creationReussie(false)
                        .message("le créateur d'un défi de procrastination doit avoir le rôle d'un gestionnaire")
                        .build();
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
