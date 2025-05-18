package fr.tlse.m1miage.ea.procrastinapp.server.services;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.TacheAEviterUpdatingRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.TachesAEviterCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.TacheAEviterResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.TachesAEviterCreatonResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.UtilisateurResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.components.TacheAEviterComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.components.UtilisateurComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.NiveauProcrastination;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.Role;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutTacheAEviter;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.*;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.TacheAEviterMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.UtilisateurMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.models.TacheAEviterEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.models.UtilisateurEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TacheAEviterService {

    private final TacheAEviterComponent tacheAEviterComponent;
    private final TacheAEviterMapper tacheAEviterMapper;
    private final UtilisateurComponent utilisateurComponent;
    private final UtilisateurMapper utilisateurMapper;

    public TachesAEviterCreatonResponseDTO createTaches(TachesAEviterCreationRequest tachesAEviter) {
        try {
            UtilisateurEntity utilisateur = utilisateurComponent.getUtilisateurById(tachesAEviter.getIdUtilisateur());
            if (utilisateur.getRole() == Role.PROCRASTINATEUR_EN_HERBE){
                List<TacheAEviterEntity> tacheAEviterEntitiesToSave = new ArrayList<>();
                List<TacheAEviterEntity> tacheAEviterEntitiesToUpdate = tacheAEviterMapper.RequestsToEntities(tachesAEviter.getTaches());
                tacheAEviterEntitiesToUpdate
                        .stream()
                        .peek(tache -> {
                            tache.setStatut(StatutTacheAEviter.EN_ATTENTE);
                            tache.setDateCreation(LocalDate.now());
                            tache.setUtilisateurEntity(utilisateur);
                        })
                        .forEach(tacheAEviterEntitiesToSave::add);
                tacheAEviterComponent.createTaches(tacheAEviterEntitiesToSave);
                return new TachesAEviterCreatonResponseDTO(true, "Toutes les tâches ont été créées avec succès");
            }
            else {
                return new TachesAEviterCreatonResponseDTO(false, "Le créateur des tâches à éviter doit être un procrastinateur en herbe");
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

    public List<TacheAEviterEntity> getTachesByUtilisateur(UtilisateurEntity utilisateurEntity) {
        return tacheAEviterComponent.getTachesByUtilisateur(utilisateurEntity);
    }


    public TacheAEviterResponseDTO updateTache(Long idTache, TacheAEviterUpdatingRequest updatingRequest) {
        try {
            TacheAEviterEntity tacheToUpdate = tacheAEviterComponent.getTacheById(idTache);
            // mise à jour des champs de l'entité par rapport au request
            tacheAEviterMapper.updateEntityFromRequest(updatingRequest, tacheToUpdate);
            /* implémentation des règles métiers liéés au statut de la tâche */
            UtilisateurEntity utilisateur = tacheToUpdate.getUtilisateurEntity();
            LocalDate dateLimite = tacheToUpdate.getDateLimite();
            LocalDate dateDeMiseAJour = LocalDate.now();
            StatutTacheAEviter statut = tacheToUpdate.getStatut();
            if (statut == StatutTacheAEviter.EVITEE_AVEC_SUCCES){
                // on vérifie que la date limite est bien passée
                if (dateLimite.isBefore(dateDeMiseAJour)){
                    /* attribution des points au procrastinateur */
                    int pointsMax = 200;
                    int degreUrgence = tacheToUpdate.getDegreUrgence();
                    // calcul des jours de retard
                    int joursDeRetard = (int) ChronoUnit.DAYS.between(dateLimite, dateDeMiseAJour);
                    int points = Integer.min (( (degreUrgence * 10) + (joursDeRetard * 5) ), pointsMax);
                    utilisateur.setPointsAccumules(utilisateur.getPointsAccumules() + points);
                    // mise à jour du niveau de procrastination de l'utilisateur après la modification de ses points
                    utilisateur = utilisateurComponent.updateNiveauProcrastination(utilisateur);
                    UtilisateurEntity updatedUtilisateur = utilisateurComponent.updateUtilisateur(utilisateur);
                    tacheToUpdate.setUtilisateurEntity(updatedUtilisateur);
                }
                else {
                    throw new UpdatingFailedRestException("La date limite doit être passée pour éviter une tâche avec succès");
                }
            }
            if (statut == StatutTacheAEviter.REALISEE_IN_EXTREMIS || statut == StatutTacheAEviter.CATASTROPHE){
                // on vérifie que la date limite n'est pas encore passée
                if (dateLimite.isAfter(dateDeMiseAJour) || dateLimite.isEqual(dateDeMiseAJour)){
                    /* vérification de la règle de déchéance */
                    // on récupère les taches réalisées dans le mois
                    List<TacheAEviterEntity> tachesRealiseesDansLeMois = new ArrayList<>();
                    tacheAEviterComponent.getTachesByUtilisateur(utilisateur)
                            .stream()
                            // récupération des tâches à part celle-la
                            .filter(tache -> tache.getId() != tacheToUpdate.getId())
                            // les tâches complétées
                            .filter(tache -> (tache.getStatut() == StatutTacheAEviter.REALISEE_IN_EXTREMIS) || (tache.getStatut() == StatutTacheAEviter.CATASTROPHE))
                            // complétées dans ce mois
                            .filter(tache -> (tache.getDateLimite().getYear() == dateDeMiseAJour.getYear() && tache.getDateLimite().getMonth() == dateDeMiseAJour.getMonth()))
                            // ajout des tâches dans la liste des tâches réalisées dans le mois
                            .forEach(tachesRealiseesDansLeMois::add);
                    // on vérifie si l'utilisateur a complèté déjà 5 tâches
                    if (tachesRealiseesDansLeMois.size() == 5){
                        // avec la tâche actuelle, l'utilisateur a donc complèté plus de 5 tâches, il perd son niveau
                        if (utilisateur.getNiveauProcrastination() == NiveauProcrastination.INTERMEDIAIRE){
                            utilisateur.setNiveauProcrastination(NiveauProcrastination.DEBUTANT);
                            UtilisateurEntity updatedUtilisateur = utilisateurComponent.updateUtilisateur(utilisateur);
                            tacheToUpdate.setUtilisateurEntity(updatedUtilisateur);
                        }
                        if (utilisateur.getNiveauProcrastination() == NiveauProcrastination.EXPERT){
                            utilisateur.setNiveauProcrastination(NiveauProcrastination.INTERMEDIAIRE);
                            UtilisateurEntity updatedUtilisateur = utilisateurComponent.updateUtilisateur(utilisateur);
                            tacheToUpdate.setUtilisateurEntity(updatedUtilisateur);
                        }
                    }
                }
                else {
                    throw new UpdatingFailedRestException("Une tâche ne peut être réalisée après sa date limite");
                }
            }
            UtilisateurResponseDTO utilisateurDTO = utilisateurMapper.entityToResponseDTO(tacheToUpdate.getUtilisateurEntity());
            TacheAEviterEntity updatedTache = tacheAEviterComponent.updateTache(tacheToUpdate);
            TacheAEviterResponseDTO tacheAEviterResponseDTO = tacheAEviterMapper.entityToResponseDTO(updatedTache);
            tacheAEviterResponseDTO.setUtilisateur(utilisateurDTO);
            return tacheAEviterResponseDTO;
        }
        catch (EntiteNotFoundException | NotFoundRestException e){
            throw new NotFoundRestException(e.getMessage());
        }
        catch (BadRequestRestException e){
            throw new BadRequestRestException(e.getMessage());
        }
        catch (ForbiddenRestException e){
            throw new ForbiddenRestException(e.getMessage());
        }
        catch (UpdatingFailedRestException e){
            throw new UpdatingFailedRestException(e.getMessage());
        }
    }
}
