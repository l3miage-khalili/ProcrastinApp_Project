package fr.tlse.m1miage.ea.procrastinapp.server.controllers;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints.ExcuseCreativeEndpoints;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.ExcuseCreativeRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.ExcuseCreativeVoteRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.ExcuseCreativeResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.rest.ForbiddenRestException;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.services.ExcuseCreativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequiredArgsConstructor
public class ExcuseCreativeController implements ExcuseCreativeEndpoints {

    private final ExcuseCreativeService excuseCreativeService;

    @Override
    public ExcuseCreativeResponseDTO createExcuseCreative(ExcuseCreativeRequest excuseCreativeRequest) {
        try{
           return excuseCreativeService.createExcuseCreative(excuseCreativeRequest);
        } catch (EntiteNotFoundException | ForbiddenRestException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,e.getMessage());
        }
    }

    @Override
    public String voterExcuseCreative(ExcuseCreativeVoteRequest request) {
        try {
            int response = excuseCreativeService.voterExcuseCreative(request);

            switch (response) {
                case -1:
                    throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Vous devez etre un procrastinateur en herbe pour voter.");
                case 0:
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'excuse creative n'existe pas");
            }

            return "Vote ajouté !";

        }catch (EntiteNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }
}
