package fr.tlse.m1miage.ea.procrastinapp.server.components;

import fr.tlse.m1miage.ea.procrastinapp.rest_api.responses.ExcuseCreativeResponseDTO;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.models.ExcuseCreativeEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.repositories.ExcuseCreativeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<ExcuseCreativeEntity> afficherToutLeClassement() {
        //trie par ordre decroissant sur le nombre de vote reçue
        return excuseCreativeRepository.findAll(Sort.by(Sort.Direction.DESC, "votesRecus"));
    }
    public List<ExcuseCreativeEntity> afficherClassement(int nbClassements) {
        //resultat avec un nombre d'elements définis
        PageRequest pageRequest = PageRequest.of(0,nbClassements,Sort.by(Sort.Direction.DESC, "votesRecus"));
        return excuseCreativeRepository.findAll(pageRequest).getContent();
    }
}
