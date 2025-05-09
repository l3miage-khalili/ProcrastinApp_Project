package fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.TachesAEviterCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.TachesAEviterCreatonResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/taches-a-eviter")
@CrossOrigin("*")
public interface TacheAEviterEndpoints {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    TachesAEviterCreatonResponseDTO createTaches(@RequestBody TachesAEviterCreationRequest tachesAEviterCreationRequest);
}
