package fr.tlse.m1miage.ea.procrastinapp.server.components;

import fr.tlse.m1miage.ea.procrastinapp.server.models.TacheAEviterEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.repositories.TacheAEviterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TacheAEviterComponent {

    private final TacheAEviterRepository tacheAEviterRepository;

    public List<TacheAEviterEntity> createTaches(List<TacheAEviterEntity> tacheAEviterEntities) {
        return tacheAEviterRepository.saveAll(tacheAEviterEntities);
    }

}
