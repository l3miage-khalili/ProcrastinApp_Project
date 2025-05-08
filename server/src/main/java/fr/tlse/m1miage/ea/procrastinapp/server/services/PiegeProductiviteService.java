package fr.tlse.m1miage.ea.procrastinapp.server.services;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.PiegeProductiviteRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.PiegeProductiviteResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.components.PiegeProductiviteComponent;
import fr.tlse.m1miage.ea.procrastinapp.server.mappers.PiegeProductiviteMapper;
import fr.tlse.m1miage.ea.procrastinapp.server.models.PiegeProductiviteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PiegeProductiviteService {

    @Autowired
    private final PiegeProductiviteComponent piegeProductiviteComponent;
    @Autowired
    private final PiegeProductiviteMapper piegeProductiviteMapper;

    public PiegeProductiviteResponseDTO creerPiegeProductivite(PiegeProductiviteRequest piegeProductiviteRequest) {
        PiegeProductiviteEntity piegeProductiviteEntityToCreate = piegeProductiviteMapper.piegeProductiviteRequestToEntity(piegeProductiviteRequest);
        piegeProductiviteEntityToCreate.setDateCreation(LocalDate.now());
        System.out.println(piegeProductiviteEntityToCreate);
        PiegeProductiviteEntity piegeProductiviteEntityCreated = piegeProductiviteComponent.creerPiegeProductivite(piegeProductiviteEntityToCreate);

        return piegeProductiviteMapper.entityToResponseDTO(piegeProductiviteEntityCreated);
    }


}
