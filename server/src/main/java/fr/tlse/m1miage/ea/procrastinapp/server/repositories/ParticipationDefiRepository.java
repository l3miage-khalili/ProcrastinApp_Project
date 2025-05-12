package fr.tlse.m1miage.ea.procrastinapp.server.repositories;

import fr.tlse.m1miage.ea.procrastinapp.server.models.ParticipationDefiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipationDefiRepository extends JpaRepository<ParticipationDefiEntity, Long> {

    int countParticipationDefiEntitiesByUtilisateurId(Long utilisateurId);

    int countParticipationDefiEntitiesByDefiId(Long defiId);
}
