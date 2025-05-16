package fr.tlse.m1miage.ea.procrastinapp.server.mappers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.ExcuseCreativeRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.ExcuseCreativeResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.models.ExcuseCreativeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ExcuseCreativeMapper {
    @Mapping(source = "utilisateurEntity.id", target = "auteur")
    ExcuseCreativeResponseDTO entityToResponseDTO(ExcuseCreativeEntity entity);
    ExcuseCreativeEntity requestToEntity(ExcuseCreativeRequest request);
}
