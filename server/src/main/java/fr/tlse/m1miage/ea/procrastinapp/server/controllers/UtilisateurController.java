package fr.tlse.m1miage.ea.procrastinapp.server.controllers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints.UtilisateurEndpoints;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.UtilisateurCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.UtilisateurResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.services.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UtilisateurController implements UtilisateurEndpoints {

    private final UtilisateurService utilisateurService;

    @Override
    public UtilisateurResponseDTO createUtilisateur(UtilisateurCreationRequest utilisateurCreationRequest, Long idCreateur) {
        return utilisateurService.createUtilisateur(utilisateurCreationRequest, idCreateur);
    }
}
