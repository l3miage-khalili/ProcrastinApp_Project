package fr.tlse.m1miage.ea.procrastinapp.server.services;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.RecompenseCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.RecompenseResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.components.RecompenseComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.BadRequestRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.CreationFailedRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.ForbiddenRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.RecompenseMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.models.RecompenseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecompenseService {

    private final RecompenseComponent recompenseComponent;
    private final RecompenseMapper recompenseMapper;

    public RecompenseResponseDTO createRecompense(RecompenseCreationRequest recompenseCreationRequest) {
        try {
            RecompenseEntity entityFromRequest = recompenseMapper.creationRequestToEntity(recompenseCreationRequest);
            RecompenseEntity savedRecompense = recompenseComponent.createRecompense(entityFromRequest);
            return recompenseMapper.entityToResponseDTO(savedRecompense);
        }
        catch (BadRequestRestException e){
            throw new BadRequestRestException(e.getMessage());
        }
        catch (CreationFailedRestException e){
            throw new CreationFailedRestException(e.getMessage());
        }
        catch (ForbiddenRestException e){
            throw new ForbiddenRestException(e.getMessage());
        }
    }
}
