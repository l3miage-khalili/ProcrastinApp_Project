package fr.tlse.m1miage.ea.procrastinapp.server.components;

import fr.tlse.m1miage.ea.procrastinapp.server.models.ConfrontationPiegeEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.repositories.ConfrontationPiegeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConfrontationPiegeComponent {

    private final ConfrontationPiegeRepository confrontationPiegeRepository;

    public ConfrontationPiegeEntity createConfrontationPiege(ConfrontationPiegeEntity confrontationPiegeEntity){
        return confrontationPiegeRepository.save(confrontationPiegeEntity);
    }
}
