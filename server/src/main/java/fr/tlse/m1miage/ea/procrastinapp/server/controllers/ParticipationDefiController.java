package fr.tlse.m1miage.ea.procrastinapp.server.controllers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints.ParticipationDefiEndpoints;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.ParticipationDefiCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.ParticipationDefiResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.services.ParticipationDefiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ParticipationDefiController implements ParticipationDefiEndpoints {

    private final ParticipationDefiService participationDefiService;

    @Override
    public ParticipationDefiResponseDTO createParticipationDefi(ParticipationDefiCreationRequest participationCreationRequest) {
        return participationDefiService.createParticipationDefi(participationCreationRequest);
    }
}
