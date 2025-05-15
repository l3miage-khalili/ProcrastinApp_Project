package fr.tlse.m1miage.ea.procrastinapp.rest_api.endpoints;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.ExcuseCreativeRequest;
import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.ExcuseCreativeResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/excuseCreative")
@CrossOrigin("*")
public interface ExcuseCreativeEndpoints {

    @PostMapping("/")
    ExcuseCreativeResponseDTO createExcuseCreative(@RequestBody ExcuseCreativeRequest excuseCreativeRequest);
}
