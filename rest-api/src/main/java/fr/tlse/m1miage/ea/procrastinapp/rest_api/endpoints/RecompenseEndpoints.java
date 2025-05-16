package fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.RecompenseCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.RecompenseResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/recompenses")
@CrossOrigin("*")
public interface RecompenseEndpoints {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    RecompenseResponseDTO createRecompense(@RequestBody RecompenseCreationRequest recompenseCreationRequest);
}
