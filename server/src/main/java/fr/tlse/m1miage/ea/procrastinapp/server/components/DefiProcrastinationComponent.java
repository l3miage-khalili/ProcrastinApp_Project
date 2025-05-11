package fr.tlse.m1miage.ea.procrastinapp.server.components;

import fr.tlse.m1miage.ea.procrastinapp.server.models.DefiProcrastinationEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.repositories.DefiProcrastinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefiProcrastinationComponent {

    private final DefiProcrastinationRepository defiProcrastinationRepository;

    public DefiProcrastinationEntity createDefiProcrastination(DefiProcrastinationEntity defiProcrastinationEntity){
        return defiProcrastinationRepository.save(defiProcrastinationEntity);
    }

}
