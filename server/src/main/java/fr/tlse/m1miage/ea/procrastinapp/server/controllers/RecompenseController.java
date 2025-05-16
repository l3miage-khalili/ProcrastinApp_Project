package fr.tlse.m1miage.ea.procrastinapp.server.controllers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints.RecompenseEndpoints;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.RecompenseCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.RecompenseResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.services.RecompenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class RecompenseController implements RecompenseEndpoints {

    private final RecompenseService recompenseService;

    @Override
    public RecompenseResponseDTO createRecompense(RecompenseCreationRequest recompenseCreationRequest) {
        return recompenseService.createRecompense(recompenseCreationRequest);
    }
}
