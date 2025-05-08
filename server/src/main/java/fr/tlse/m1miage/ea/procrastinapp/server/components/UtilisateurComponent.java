package fr.tlse.m1miage.ea.procrastinapp.server.components;

import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.models.UtilisateurEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.repositories.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UtilisateurComponent {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurEntity createUtilisateur(UtilisateurEntity utilisateurEntity) {
        return utilisateurRepository.save(utilisateurEntity);
    }

    public UtilisateurEntity getUtilisateurById(Long idUtilisateur) throws EntiteNotFoundException {
        return utilisateurRepository.findById(idUtilisateur)
                .orElseThrow(() -> new EntiteNotFoundException(String.format("Utilisateur de référence [%s] non trouvé", idUtilisateur))) ;
    }
}
