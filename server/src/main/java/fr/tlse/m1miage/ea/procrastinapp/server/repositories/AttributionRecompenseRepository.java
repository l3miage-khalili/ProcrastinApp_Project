package fr.tlse.m1miage.ea.procrastinapp.server.repositories;

import fr.tlse.m1miage.ea.procrastinapp.server.models.AttributionRecompenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributionRecompenseRepository extends JpaRepository<AttributionRecompenseEntity, Long> {
}
