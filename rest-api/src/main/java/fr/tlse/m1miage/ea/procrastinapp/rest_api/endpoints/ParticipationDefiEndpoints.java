package fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.ParticipationDefiCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.ParticipationDefiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/participations-defis")
@CrossOrigin("*")
public interface ParticipationDefiEndpoints {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    ParticipationDefiResponseDTO createParticipationDefi(@RequestBody ParticipationDefiCreationRequest participationCreationRequest);
}
