package fr.tlse.m1miage.ea.procrastinapp.server.mappers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.RecompenseCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.RecompenseResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.models.RecompenseEntity;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

@Mapper
public interface RecompenseMapper {

    RecompenseEntity creationRequestToEntity(@RequestBody RecompenseCreationRequest recompenseCreationRequest);

    RecompenseResponseDTO entityToResponseDTO(RecompenseEntity recompenseEntity);
}
