package fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.DefiProcrastinationCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.DefiProcrastinationResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/defis-procrastination")
@CrossOrigin("*")
public interface DefiProcrastinationEndpoints {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    DefiProcrastinationResponseDTO createDefiProcrastination(@RequestBody DefiProcrastinationCreationRequest defiRequest) ;
}
