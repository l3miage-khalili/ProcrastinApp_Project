package fr.tlse.m1miage.ea.procrastinapp.server.services;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.PiegeProductiviteRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.PiegeProductiviteResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.components.PiegeProductiviteComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.components.UtilisateurComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.enums.Role;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.ForbiddenRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.PiegeProductiviteMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.models.PiegeProductiviteEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.models.UtilisateurEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PiegeProductiviteService {

    private final PiegeProductiviteComponent piegeProductiviteComponent;
    private final PiegeProductiviteMapper piegeProductiviteMapper;
    private final UtilisateurComponent utilisateurComponent;

    public PiegeProductiviteResponseDTO creerPiegeProductivite(PiegeProductiviteRequest piegeProductiviteRequest) throws EntiteNotFoundException, ForbiddenRestException {
        //recuperation de l'objet utilisateur
        UtilisateurEntity utilisateur = utilisateurComponent.getUtilisateurById(piegeProductiviteRequest.getCreateur());

        PiegeProductiviteEntity piegeProductiviteEntityToCreate = piegeProductiviteMapper.piegeProductiviteRequestToEntity(piegeProductiviteRequest);

        //completion de l'objet piegeProductiviteEntity avant enregistrement
        piegeProductiviteEntityToCreate.setUtilisateurEntity(utilisateur);
        piegeProductiviteEntityToCreate.setDateCreation(LocalDate.now());

//       creation d'un piege de productivite seulement si le role du createur est de type ANTI_PROCRASTINATEUR_REPENTI'
        if(utilisateur.getRole().equals(Role.ANTI_PROCRASTINATEUR_REPENTI)){
            PiegeProductiviteEntity piegeProductiviteEntityCreated = piegeProductiviteComponent.creerPiegeProductivite(piegeProductiviteEntityToCreate);
            PiegeProductiviteResponseDTO response = piegeProductiviteMapper.entityToResponseDTO(piegeProductiviteEntityCreated);
            response.setCreateur(piegeProductiviteRequest.getCreateur());

            return response;
        }else{
            throw new ForbiddenRestException("L'utilisateur doit avoir le role 'ANTI_PROCRASTINATEUR_REPENTI' pour créer un piege de productivite !");
        }

    }




}
