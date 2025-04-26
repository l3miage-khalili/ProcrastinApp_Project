package fr.tlse.m1miage.ea.procrastinapp.server.services;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.UtilisateurCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.UtilisateurResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.components.UtilisateurComponent;
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

    public UtilisateurResponseDTO createUtilisateur(UtilisateurCreationRequest utilisateurCreationRequest) {
        UtilisateurEntity utilisateurEntity = utilisateurMapper.creationRequestToEntity(utilisateurCreationRequest);
        utilisateurEntity.setDateInscription(LocalDate.now());
        utilisateurEntity.setPointsAccumules(0);
        return utilisateurMapper.entityToResponseDTO(utilisateurComponent.createUtilisateur(utilisateurEntity));
    }
}
