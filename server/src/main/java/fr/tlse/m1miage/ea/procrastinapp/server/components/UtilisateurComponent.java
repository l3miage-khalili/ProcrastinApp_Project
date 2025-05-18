package fr.tlse.m1miage.ea.procrastinapp.server.components;

import fr.tlse.m1miage.ea.procrastinapp.server.enums.NiveauProcrastination;
import fr.tlse.m1miage.ea.procrastinapp.server.exceptions.technical.EntiteNotFoundException;
import fr.tlse.m1miage.ea.procrastinapp.server.models.UtilisateurEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.repositories.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

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


    public UtilisateurEntity updateUtilisateur(UtilisateurEntity utilisateurEntity){
        return utilisateurRepository.save(utilisateurEntity);
    }

    public UtilisateurEntity updateNiveauProcrastination(UtilisateurEntity utilisateur){
        int pointsAccumules = utilisateur.getPointsAccumules();
        if (pointsAccumules < 500){
            utilisateur.setNiveauProcrastination(NiveauProcrastination.DEBUTANT);
        } else if (pointsAccumules < 1000) {
            utilisateur.setNiveauProcrastination(NiveauProcrastination.INTERMEDIAIRE);
        }
        else {
            utilisateur.setNiveauProcrastination(NiveauProcrastination.EXPERT);
        }
        return utilisateur;
    }
}
