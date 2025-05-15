package fr.tlse.m1miage.ea.procrastinapp.server.components;


import fr.tlse.m1miage.ea.procrastinapp.server.models.PiegeProductiviteEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.repositories.PiegeProductiviteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PiegeProductiviteComponent {

    private final PiegeProductiviteRepository piegeProductiviteRepository;

    public PiegeProductiviteEntity creerPiegeProductivite(PiegeProductiviteEntity piegeProductiviteEntity) {
        return piegeProductiviteRepository.save(piegeProductiviteEntity);
    }
}
