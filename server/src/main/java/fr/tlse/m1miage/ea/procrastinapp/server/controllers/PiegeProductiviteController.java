package fr.tlse.m1miage.ea.procrastinapp.server.controllers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints.PiegeProductiviteEndPoint;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.PiegeProductiviteRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.PiegeProductiviteResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.ForbiddenRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.models.PiegeProductiviteEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.services.PiegeProductiviteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequiredArgsConstructor
public class PiegeProductiviteController implements PiegeProductiviteEndPoint  {

    private final PiegeProductiviteService piegeProductiviteService;

    @Override
    public PiegeProductiviteResponseDTO creerPiegeProductivite(PiegeProductiviteRequest request) {
        try{
            return piegeProductiviteService.creerPiegeProductivite(request);
        }catch (ForbiddenRestException | EntiteNotFoundException e){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,e.getMessage());
        }
    }
}
