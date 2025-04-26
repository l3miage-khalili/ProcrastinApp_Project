package fr.tlse.m1miage.ea.procrastinapp.server.mappers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.UtilisateurCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.UtilisateurResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.models.UtilisateurEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UtilisateurMapper {

    UtilisateurResponseDTO entityToResponseDTO(UtilisateurEntity utilisateurEntity);
    UtilisateurEntity creationRequestToEntity(UtilisateurCreationRequest utilisateurCreationRequest);
}
