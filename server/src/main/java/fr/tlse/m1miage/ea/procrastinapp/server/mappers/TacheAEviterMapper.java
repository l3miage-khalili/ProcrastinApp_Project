package fr.tlse.m1miage.ea.procrastinapp.server.mappers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.TacheAEviterCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.server.models.TacheAEviterEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TacheAEviterMapper {

    List<TacheAEviterEntity> RequestsToEntities(List<TacheAEviterCreationRequest> requests);
}
