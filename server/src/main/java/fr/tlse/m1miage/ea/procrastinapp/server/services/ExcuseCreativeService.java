package fr.tlse.m1miage.ea.procrastinapp.server.services;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.ExcuseCreativeRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.ExcuseCreativeResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.components.ExcuseCreativeComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.Role;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutExcuseCreative;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutTacheAEviter;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.ForbiddenRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.ExcuseCreativeMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.models.ExcuseCreativeEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.models.TacheAEviterEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.models.UtilisateurEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcuseCreativeService {

    private final ExcuseCreativeComponent excuseCreativeComponent;
    private final UtilisateurService utilisateurService;
    private final ExcuseCreativeMapper excuseCreativeMapper;
    private final TacheAEviterService tacheAEviterService;

    public ExcuseCreativeResponseDTO createExcuseCreative(ExcuseCreativeRequest request) throws EntiteNotFoundException,ForbiddenRestException {

        if(!peutCreerUneExcuse(request.getAuteur())){
            throw new ForbiddenRestException("Pour créer une excuse, l'utilisateur doit etre un procrastinateur en herbe et il doit avoir au moins une tâche en statut \"évitée avec succès\" ou \"catastrophe\".");
        }

        ExcuseCreativeEntity excuseCreativeToCreate = excuseCreativeMapper.requestToEntity(request);

        //completion de l'objet avant enregistrement en base
        excuseCreativeToCreate.setStatut(StatutExcuseCreative.EN_ATTENTE);
        excuseCreativeToCreate.setDateSoumission(LocalDate.now());
        excuseCreativeToCreate.setVotesRecus(0);

        ExcuseCreativeEntity excuseCreativeCreated = excuseCreativeComponent.createExcuseCreative(excuseCreativeToCreate);
        ExcuseCreativeResponseDTO response = excuseCreativeMapper.entityToResponseDTO(excuseCreativeCreated);
        response.setAuteur(request.getAuteur());

        return response;
    }

    /**
     * Test si un utilisateur remplit les conditions necessaires pour creer une excuse
     * @param idUtilisateur Long
     * @return boolean
     */
    public boolean peutCreerUneExcuse(Long idUtilisateur) throws EntiteNotFoundException {
        boolean peutCreerUneExcuse = false;

        UtilisateurEntity utilisateur = utilisateurService.getUtilisateurById(idUtilisateur);
        List<TacheAEviterEntity> listTachesUtilisateur =  tacheAEviterService.getTachesByUtilisateur(utilisateur);

        if(!utilisateur.getRole().equals(Role.PROCRASTINATEUR_EN_HERBE)){
            return false;
        }

        if(!listTachesUtilisateur.isEmpty()) {
            for (TacheAEviterEntity tache : listTachesUtilisateur) {
                if (tache.getStatut().equals(StatutTacheAEviter.EVITEE_AVEC_SUCCES) || tache.getStatut().equals(StatutTacheAEviter.CATASTROPHE)) {
                    peutCreerUneExcuse = true;
                    break;
                }
            }
        }

        return peutCreerUneExcuse;
    }

}
