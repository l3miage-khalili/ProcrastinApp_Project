package fr.tlse.m1miage.ea.procrastinapp.server.services;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.ParticipationDefiCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.DefiProcrastinationResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.ParticipationDefiResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.UtilisateurResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.components.DefiProcrastinationComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.components.ParticipationDefiComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.components.UtilisateurComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.Role;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutParticipationDefi;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.BadRequestRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.CreationFailedRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.ForbiddenRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.NotFoundRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.DefiProcrastinationMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.ParticipationDefiMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.UtilisateurMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.models.DefiProcrastinationEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.models.ParticipationDefiEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.models.UtilisateurEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ParticipationDefiService {

    private final ParticipationDefiComponent participationDefiComponent;
    private final ParticipationDefiMapper participationDefiMapper;
    private final DefiProcrastinationComponent defiProcrastinationComponent;
    private final DefiProcrastinationMapper defiProcrastinationMapper;
    private final UtilisateurComponent utilisateurComponent;
    private final UtilisateurMapper utilisateurMapper;

    public ParticipationDefiResponseDTO createParticipationDefi(ParticipationDefiCreationRequest participationCreationRequest) {
        try {
            // on vérifie que l'utilisateur a bien le rôle d'un procrastinateur
            Long idUtilisateur = participationCreationRequest.getIdUtilisateur();
            UtilisateurEntity utilisateur = utilisateurComponent.getUtilisateurById(idUtilisateur);
            if (utilisateur.getRole() != Role.PROCRASTINATEUR_EN_HERBE){
                return ParticipationDefiResponseDTO
                        .builder()
                        .creationReussie(false)
                        .message("L'utilisateur doit être un procrastinateur en herbe pour participer à un défi")
                        .build();
            }
            // on vérifie que l'utilisateur et le défi n'ont pas atteint leur nb maximum de participations
            Long idDefi = participationCreationRequest.getIdDefi();
            int nbParticipationsUtilisateur = participationDefiComponent.getNombreParticipationsByUtilisateurId(idUtilisateur);
            int nbParticipationsDefi = participationDefiComponent.getNombreParticipationsByDefiId(idDefi);
            if (nbParticipationsUtilisateur >= 3 || nbParticipationsDefi >= 5){
                return ParticipationDefiResponseDTO
                        .builder()
                        .creationReussie(false)
                        .message("l'utilisateur ou le défi a atteint le nombre maximum des participations")
                        .build();
            }
            else {
                int pointsGagnes = 0;
                DefiProcrastinationEntity defi = defiProcrastinationComponent.getDefiProcrastinationById(idDefi);
                ParticipationDefiEntity entityFromRequest = participationDefiMapper.creationRequestToEntity(participationCreationRequest);
                entityFromRequest.setDefi(defi);
                entityFromRequest.setUtilisateur(utilisateur);
                entityFromRequest.setDateInscription(LocalDate.now());
                entityFromRequest.setStatut(StatutParticipationDefi.INSCRIT);
                entityFromRequest.setPointsGagnes(pointsGagnes);
                ParticipationDefiEntity savedEntity = participationDefiComponent.createParticipationDefi(entityFromRequest);
                UtilisateurResponseDTO utilisateurDTO = utilisateurMapper.entityToResponseDTO(utilisateur);
                DefiProcrastinationResponseDTO defiDTO = defiProcrastinationMapper.entityToResponseDTO(defi);
                utilisateurDTO.setInscriptionReussie(true);
                defiDTO.setCreationReussie(true);
                ParticipationDefiResponseDTO responseDTO = participationDefiMapper.entityToResponseDTO(savedEntity);
                responseDTO.setUtilisateur(utilisateurDTO);
                responseDTO.setDefi(defiDTO);
                responseDTO.setCreationReussie(true);
                responseDTO.setMessage("la participation a été créée avec succès");
                return responseDTO;
            }
        }
        catch (EntiteNotFoundException e) {
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
