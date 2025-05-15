package fr.tlse.m1miage.ea.procrastinapp.server.services;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.UtilisateurCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.UtilisateurResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.components.UtilisateurComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.NiveauProcrastination;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.Role;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.BadRequestRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.CreationFailedRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.ForbiddenRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.NotFoundRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.UtilisateurMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.models.UtilisateurEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UtilisateurService {

    private final UtilisateurComponent utilisateurComponent;
    private final UtilisateurMapper utilisateurMapper;

    public UtilisateurResponseDTO createUtilisateur(UtilisateurCreationRequest utilisateurCreationRequest, Long idCreateur) {
        try {
            int pointsAccumules = 0 ;
            UtilisateurEntity utilisateurEntity = utilisateurMapper.creationRequestToEntity(utilisateurCreationRequest);
            if (utilisateurEntity.getRole() == Role.PROCRASTINATEUR_EN_HERBE){
                // Logique d'inscription d'un procrastinateur en herbe
                utilisateurEntity.setDateInscription(LocalDate.now());
                utilisateurEntity.setNiveauProcrastination(NiveauProcrastination.DEBUTANT);
                utilisateurEntity.setPointsAccumules(pointsAccumules);
                UtilisateurResponseDTO responseDTO = utilisateurMapper.entityToResponseDTO(utilisateurComponent.createUtilisateur(utilisateurEntity));
                responseDTO.setInscriptionReussie(true);
                responseDTO.setMessage("inscription effectuée avec succès");
                return responseDTO;
            }
            else if (utilisateurEntity.getRole() == Role.ANTI_PROCRASTINATEUR_REPENTI){
                // Logique d'inscription d'un anti-procrastinateur
                if (idCreateur != null){
                    UtilisateurEntity createurEntity = utilisateurComponent.getUtilisateurById(idCreateur);
                    if (createurEntity.getRole() == Role.GESTIONNAIRE_TEMPS_PERDU){
                        utilisateurEntity.setGestionnaire(createurEntity);
                        utilisateurEntity.setDateInscription(LocalDate.now());
                        utilisateurEntity.setPointsAccumules(pointsAccumules);
                        UtilisateurResponseDTO responseDTO = utilisateurMapper.entityToResponseDTO(utilisateurComponent.createUtilisateur(utilisateurEntity));
                        responseDTO.setInscriptionReussie(true);
                        responseDTO.setMessage("inscription effectuée avec succès");
                        return responseDTO;
                    }
                    else {
                        // y a que le gestionnaire qui a le droit d'inscrire un anti-procrastinateur
                        return UtilisateurResponseDTO
                                .builder()
                                .inscriptionReussie(false)
                                .message("Un anti-procrastinateur ne doit être inscrit que par un gestionnaire")
                                .build();
                    }
                }
                else {
                    // id du créateur non fourni, l'inscription n'est donc pas réussie
                    return UtilisateurResponseDTO
                            .builder()
                            .inscriptionReussie(false)
                            .message("fournir l'id du gestionnaire pour pouvoir créer un anti-procrastinateur")
                            .build();
                }
            }
            else {
                // role différent de procrastinateur et anti-procrastinateur, donc pas d'inscription à effectuer
                return UtilisateurResponseDTO
                        .builder()
                        .inscriptionReussie(false)
                        .message("rôle fourni invalide")
                        .build();
            }
        }
        catch (EntiteNotFoundException e) {
            throw new NotFoundRestException(e.getMessage());
        }
        catch (CreationFailedRestException e){
            throw new CreationFailedRestException(e.getMessage());
        }
        catch (BadRequestRestException e){
            throw new BadRequestRestException(e.getMessage());
        }
        catch (ForbiddenRestException e){
            throw new ForbiddenRestException(e.getMessage());
        }
    }

    public UtilisateurEntity getUtilisateurById(Long idUtilisateur) throws EntiteNotFoundException {
        return utilisateurComponent.getUtilisateurById(idUtilisateur);
    }
}
