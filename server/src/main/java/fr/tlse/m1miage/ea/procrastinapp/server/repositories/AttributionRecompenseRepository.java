package fr.tlse.m1miage.ea.procrastinapp.server.repositories;

import fr.tlse.m1miage.ea.procrastinapp.server.models.AttributionRecompenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributionRecompenseRepository extends JpaRepository<AttributionRecompenseEntity, Long> {

    // renvoie l'Id maximum de la table attributions_recompenses
    @Query("select coalesce(MAX(a.id), 0) from AttributionRecompenseEntity a")
    Long getMaxId();
}
