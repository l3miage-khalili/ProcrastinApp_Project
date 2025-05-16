package fr.tlse.m1miage.ea.procrastinapp.server.components;

import fr.tlse.m1miage.ea.procrastinapp.server.models.AttributionRecompenseEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.repositories.AttributionRecompenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AttributionRecompenseComponent {

    private final AttributionRecompenseRepository attributionRecompenseRepository;

    // renvoie l'Id maximum de la table attributions_recompenses
    public Long getMaxId(){
        return attributionRecompenseRepository.getMaxId();
    }

    public AttributionRecompenseEntity createAttributionRecompense(AttributionRecompenseEntity attributionRecompenseEntity){
        return attributionRecompenseRepository.save(attributionRecompenseEntity);
    }
}
