package fr.tlse.m1miage.ea.procrastinapp.server.components;

import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.models.ParticipationDefiEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.repositories.ParticipationDefiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParticipationDefiComponent {

    private final ParticipationDefiRepository participationDefiRepository;

    public ParticipationDefiEntity createParticipationDefi(ParticipationDefiEntity participationDefiEntity){
        return participationDefiRepository.save(participationDefiEntity);
    }

    public ParticipationDefiEntity getParticipationDefiById(Long idParticipationDefi) throws EntiteNotFoundException {
        return participationDefiRepository.findById(idParticipationDefi)
                .orElseThrow(() -> new EntiteNotFoundException(String.format("Participation de référence [%s] non trouvé", idParticipationDefi)));
    }

    public int getNombreParticipationsByUtilisateurId(Long idUtilisateur){
        return participationDefiRepository.countParticipationDefiEntitiesByUtilisateurId(idUtilisateur);
    }

    public int  getNombreParticipationsByDefiId(Long idDefi){
        return participationDefiRepository.countParticipationDefiEntitiesByDefiId(idDefi);
    }
}
