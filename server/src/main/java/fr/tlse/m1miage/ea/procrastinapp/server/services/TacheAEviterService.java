package fr.tlse.m1miage.ea.procrastinapp.server.services;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.TachesAEviterCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.TachesAEviterCreatonResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.components.TacheAEviterComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.components.UtilisateurComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.Role;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutTacheAEviter;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.BadRequestRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.CreationFailedRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.ForbiddenRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.NotFoundRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.TacheAEviterMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.models.TacheAEviterEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.models.UtilisateurEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TacheAEviterService {

    private final TacheAEviterComponent tacheAEviterComponent;
    private final TacheAEviterMapper tacheAEviterMapper;
    private final UtilisateurComponent utilisateurComponent;

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
}
