package fr.tlse.m1miage.ea.procrastinapp.server.mappers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.ConfrontationPiegeCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.ConfrontationPiegeResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.models.ConfrontationPiegeEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ConfrontationPiegeMapper {

    ConfrontationPiegeEntity creationRequestToEntity(ConfrontationPiegeCreationRequest confrontationRequest);

    ConfrontationPiegeResponseDTO entityToResponseDTO(ConfrontationPiegeEntity confrontationEntity);
}
