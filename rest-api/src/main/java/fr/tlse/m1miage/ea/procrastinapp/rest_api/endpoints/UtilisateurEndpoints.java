package fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.UtilisateurCreationRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.UtilisateurResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/utilisateurs")
@CrossOrigin("*")
public interface UtilisateurEndpoints {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    UtilisateurResponseDTO createUtilisateur(@RequestBody UtilisateurCreationRequest utilisateurCreationRequest);
}
