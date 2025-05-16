package fr.tlse.m1miage.ea.procrastinapp.server.services;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.ExcuseCreativeRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.ExcuseCreativeVoteRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.ExcuseCreativeResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.components.ExcuseCreativeComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.Role;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutExcuseCreative;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.StatutTacheAEviter;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.ForbiddenRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.NotFoundRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.ExcuseCreativeMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.models.ExcuseCreativeEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.models.TacheAEviterEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.models.UtilisateurEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        excuseCreativeToCreate.setUtilisateurEntity(utilisateurService.getUtilisateurById(request.getAuteur()));;
        ExcuseCreativeEntity excuseCreativeCreated = excuseCreativeComponent.createExcuseCreative(excuseCreativeToCreate);
//        ExcuseCreativeResponseDTO response = excuseCreativeMapper.entityToResponseDTO(excuseCreativeCreated);
        return excuseCreativeMapper.entityToResponseDTO(excuseCreativeCreated);
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

    public int voterExcuseCreative(ExcuseCreativeVoteRequest request) throws EntiteNotFoundException{
        UtilisateurEntity utilisateur = utilisateurService.getUtilisateurById(request.getVotant());

        if(utilisateur.getRole().equals(Role.PROCRASTINATEUR_EN_HERBE)){
            return excuseCreativeComponent.voterExcuseCreative(request.getExcuseCreativeId());
        }
        return -1;
    }

    public List<ExcuseCreativeResponseDTO> afficherClassement(int nbClassement) throws NotFoundRestException {
        List<ExcuseCreativeResponseDTO> result = new ArrayList<>();
        List<ExcuseCreativeEntity> classements = null;

        //check si l'utilisateur veut afficher tout le classement ou seulement un certains nombre
        if(nbClassement == 0){
            classements = excuseCreativeComponent.afficherToutLeClassement();
        }else{
            classements = excuseCreativeComponent.afficherClassement(nbClassement);
        }

        //on informe l'utilisateur qu'aucune excuse creative n'existe pour le moment
        if(classements.size() == 0){
            throw new NotFoundRestException("Aucune excuse créative n'existe pour le moement");
        }

        //transformation vers une liste de responseDTO object
        for(ExcuseCreativeEntity classement: classements){
            result.add(excuseCreativeMapper.entityToResponseDTO(classement));
        }

        return result;
    }
}
