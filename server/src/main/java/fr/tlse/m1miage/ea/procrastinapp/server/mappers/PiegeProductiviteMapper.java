package fr.tlse.m1miage.ea.procrastinapp.server.mappers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.PiegeProductiviteRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.PiegeProductiviteResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.models.PiegeProductiviteEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PiegeProductiviteMapper {
    PiegeProductiviteResponseDTO entityToResponseDTO(PiegeProductiviteEntity entity);
    PiegeProductiviteEntity piegeProductiviteRequestToEntity(PiegeProductiviteRequest piegeProductiviteRequest);
}
