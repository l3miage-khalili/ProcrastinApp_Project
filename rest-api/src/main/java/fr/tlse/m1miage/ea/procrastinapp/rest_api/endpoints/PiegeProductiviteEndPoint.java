package fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.PiegeProductiviteRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.PiegeProductiviteResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/piegeProductivite")
@CrossOrigin("*")
public interface PiegeProductiviteEndPoint {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public PiegeProductiviteResponseDTO creerPiegeProductivite(@RequestBody PiegeProductiviteRequest request);
}
