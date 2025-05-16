package fr.tlse.m1miage.ea.procrastinapp.server.controllers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints.ConfrontationPiegeEndpoints;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.ConfrontationPiegeCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.ConfrontationPiegeResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.services.ConfrontationPiegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ConfrontationPiegeController implements ConfrontationPiegeEndpoints {

    private final ConfrontationPiegeService confrontationPiegeService;

    @Override
    public ConfrontationPiegeResponseDTO createConfrontationPiege(ConfrontationPiegeCreationRequest confrontationCreationRequest) {
        return confrontationPiegeService.createConfrontationPiege(confrontationCreationRequest);
    }
}
