package fr.tlse.m1miage.ea.procrastinapp.server.controllers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints.AttributionRecompenseEndpoints;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.AttributionRecompenseCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.AttributionRecompenseResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.services.AttributionRecompenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AttributionRecompenseController implements AttributionRecompenseEndpoints {

    private final AttributionRecompenseService attributionRecompenseService;

    @Override
    public AttributionRecompenseResponseDTO createAttributionRecompense(AttributionRecompenseCreationRequest request) {
        return attributionRecompenseService.createAttributionRecompense(request);
    }
}
