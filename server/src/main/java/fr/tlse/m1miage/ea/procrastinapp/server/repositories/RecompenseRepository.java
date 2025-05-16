package fr.tlse.m1miage.ea.procrastinapp.server.repositories;

import fr.tlse.m1miage.ea.procrastinapp.server.models.RecompenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecompenseRepository extends JpaRepository<RecompenseEntity, Long> {

    RecompenseEntity findByTitre(String titre);
}
