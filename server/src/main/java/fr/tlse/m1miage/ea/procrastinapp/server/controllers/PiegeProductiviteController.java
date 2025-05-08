package fr.tlse.m1miage.ea.procrastinapp.server.controllers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints.PiegeProductiviteEndPoint;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.PiegeProductiviteRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.PiegeProductiviteResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.models.PiegeProductiviteEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.services.PiegeProductiviteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PiegeProductiviteController implements PiegeProductiviteEndPoint  {

    @Autowired
    private final PiegeProductiviteService piegeProductiviteService;

    @Override
    public PiegeProductiviteResponseDTO creerPiegeProductivite(PiegeProductiviteRequest request) {
        System.out.println(request);
        PiegeProductiviteResponseDTO PiegeProductiviteResponseDTO= piegeProductiviteService.creerPiegeProductivite(request);
        return PiegeProductiviteResponseDTO;
    }

}
