package fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.ConfrontationPiegeCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.ConfrontationPiegeResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/confrontations-pieges")
@CrossOrigin("*")
public interface ConfrontationPiegeEndpoints {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    ConfrontationPiegeResponseDTO createConfrontationPiege(@RequestBody ConfrontationPiegeCreationRequest confrontationCreationRequest);
}
