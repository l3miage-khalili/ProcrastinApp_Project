package fr.tlse.m1miage.ea.procrastinapp.server.components;

import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.models.RecompenseEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.repositories.RecompenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecompenseComponent {

    private final RecompenseRepository recompenseRepository;

    public RecompenseEntity getRecompenseByTitre(String titre){
        return recompenseRepository.findByTitre(titre);
    }

    public RecompenseEntity getRecompenseById(Long idRecompense) throws EntiteNotFoundException{
        return recompenseRepository.findById(idRecompense)
                .orElseThrow(() -> new EntiteNotFoundException(String.format("Récompense de référence [%s] non trouvée", idRecompense)));
    }

    public RecompenseEntity createRecompense(RecompenseEntity recompenseEntity){
        return recompenseRepository.save(recompenseEntity);
    }
}
