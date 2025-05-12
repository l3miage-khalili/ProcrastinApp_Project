package fr.tlse.m1miage.ea.procrastinapp.server.mappers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.ParticipationDefiCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.ParticipationDefiResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.models.ParticipationDefiEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ParticipationDefiMapper {

    ParticipationDefiEntity creationRequestToEntity(ParticipationDefiCreationRequest participationRequest);
    ParticipationDefiResponseDTO entityToResponseDTO(ParticipationDefiEntity participationEntity);
}
