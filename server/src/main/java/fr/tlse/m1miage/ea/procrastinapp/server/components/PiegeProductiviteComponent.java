package fr.tlse.m1miage.ea.procrastinapp.server.components;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.requests.PiegeProductiviteRequest;
import fr.tlse.m1miage.ea.procrastinapp.server.models.PiegeProductiviteEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.repositories.PiegeProductiviteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PiegeProductiviteComponent {

    @Autowired
    private final PiegeProductiviteRepository piegeProductiviteRepository;

    public PiegeProductiviteEntity creerPiegeProductivite(PiegeProductiviteEntity piegeProductiviteEntity) {
        System.out.println("save");
        System.out.println(piegeProductiviteEntity);
        PiegeProductiviteEntity piegeProductiviteEntityCreated = piegeProductiviteRepository.save(piegeProductiviteEntity);
        System.out.println(piegeProductiviteEntityCreated);
        return piegeProductiviteEntityCreated;
    }
}
