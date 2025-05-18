package fr.tlse.m1miage.ea.procrastinapp.server.components;

import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.models.TacheAEviterEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.models.UtilisateurEntity;
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

    public List<TacheAEviterEntity> getTachesByUtilisateur(UtilisateurEntity utilisateurEntity) {
        return tacheAEviterRepository.findAllByUtilisateurEntity(utilisateurEntity);
    }

    public TacheAEviterEntity getTacheById(Long idTache) throws EntiteNotFoundException {
        return tacheAEviterRepository.findById(idTache)
                .orElseThrow(() -> new EntiteNotFoundException(String.format("tâche de référence [%s] non trouvée", idTache)));
    }

    public TacheAEviterEntity updateTache(TacheAEviterEntity tacheAEviterEntity){
        return tacheAEviterRepository.save(tacheAEviterEntity);
    }
}
