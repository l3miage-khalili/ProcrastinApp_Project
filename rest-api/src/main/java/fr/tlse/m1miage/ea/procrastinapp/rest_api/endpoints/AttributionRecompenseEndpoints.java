package fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.AttributionRecompenseCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.AttributionRecompenseResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/attributions-recompenses")
@CrossOrigin("*")
public interface AttributionRecompenseEndpoints {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    AttributionRecompenseResponseDTO createAttributionRecompense(@RequestBody AttributionRecompenseCreationRequest request);

}
