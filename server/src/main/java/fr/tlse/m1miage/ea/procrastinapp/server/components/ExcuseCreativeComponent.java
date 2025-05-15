package fr.tlse.m1miage.ea.procrastinapp.server.components;

import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.models.ExcuseCreativeEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.repositories.ExcuseCreativeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExcuseCreativeComponent {

    private final ExcuseCreativeRepository excuseCreativeRepository;

    public ExcuseCreativeEntity createExcuseCreative(ExcuseCreativeEntity excuseCreativeEntity) {
        return excuseCreativeRepository.save(excuseCreativeEntity);
    }

    public int voterExcuseCreative(Long id) throws EntiteNotFoundException{
        return excuseCreativeRepository.incrementVoteById(id);
    }
}
