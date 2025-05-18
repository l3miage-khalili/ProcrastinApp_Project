package fr.tlse.m1miage.ea.procrastinapp.server.mappers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.TacheAEviterCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.TacheAEviterUpdatingRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.TacheAEviterResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.models.TacheAEviterEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper
public interface TacheAEviterMapper {

    List<TacheAEviterEntity> RequestsToEntities(List<TacheAEviterCreationRequest> requests);

    TacheAEviterResponseDTO entityToResponseDTO(TacheAEviterEntity tacheAEviterEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(TacheAEviterUpdatingRequest updatingRequest, @MappingTarget TacheAEviterEntity tacheAEviterEntity);
}
