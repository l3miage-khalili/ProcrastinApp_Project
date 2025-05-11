package fr.tlse.m1miage.ea.procrastinapp.server.mappers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.DefiProcrastinationCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.DefiProcrastinationResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.models.DefiProcrastinationEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DefiProcrastinationMapper {

    DefiProcrastinationEntity creationRequestToEntity(DefiProcrastinationCreationRequest defiCreationRequest);

    DefiProcrastinationResponseDTO entityToResponseDTO(DefiProcrastinationEntity defiEntity);
}
