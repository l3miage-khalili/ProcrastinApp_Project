package fr.tlse.m1miage.ea.procrastinapp.server.controllers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints.TacheAEviterEndpoints;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.TachesAEviterCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.TachesAEviterCreatonResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.services.TacheAEviterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TacheAEviterController implements TacheAEviterEndpoints {

    private final TacheAEviterService tacheAEviterService;

    @Override
    public TachesAEviterCreatonResponseDTO createTaches(TachesAEviterCreationRequest tachesAEviterCreationRequest) {
        return tacheAEviterService.createTaches(tachesAEviterCreationRequest);
    }
}
