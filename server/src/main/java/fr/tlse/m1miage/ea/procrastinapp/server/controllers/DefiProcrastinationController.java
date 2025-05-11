package fr.tlse.m1miage.ea.procrastinapp.server.controllers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints.DefiProcrastinationEndpoints;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.DefiProcrastinationCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.DefiProcrastinationResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.services.DefiProcrastinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class DefiProcrastinationController implements DefiProcrastinationEndpoints {

    private final DefiProcrastinationService defiProcrastinationService;

    @Override
    public DefiProcrastinationResponseDTO createDefiProcrastination(DefiProcrastinationCreationRequest defiRequest) {
        return defiProcrastinationService.createDefiProcrastination(defiRequest);
    }
}
