package fr.tlse.m1miage.ea.procrastinapp.server.components;


import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
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

    public PiegeProductiviteEntity getPiegeProductiviteById(Long idPiege) throws EntiteNotFoundException {
        return piegeProductiviteRepository.findById(idPiege)
                .orElseThrow(() -> new EntiteNotFoundException(String.format("Piège de référence [%s] non trouvé", idPiege)));
    }
}
