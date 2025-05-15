package fr.tlse.m1miage.ea.procrastinapp.server.repositories;

import fr.tlse.m1miage.ea.procrastinapp.server.models.TacheAEviterEntity;
import fr.tlse.m1miage.ea.procrastinapp.server.models.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheAEviterRepository extends JpaRepository<TacheAEviterEntity, Long> {
    List<TacheAEviterEntity> findAllByUtilisateurEntity(UtilisateurEntity utilisateurEntity);
}
