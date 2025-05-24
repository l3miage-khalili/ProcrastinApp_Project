package fr.tlse.m1miage.ea.procrastinapp.server.mappers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.AttributionRecompenseCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.AttributionRecompenseResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.models.AttributionRecompenseEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AttributionRecompenseMapper {

    AttributionRecompenseEntity creationRequestToEntity(AttributionRecompenseCreationRequest creationRequest);
    AttributionRecompenseResponseDTO entityToResponseDTO(AttributionRecompenseEntity attributionRecompenseEntity);
}
