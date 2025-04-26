package fr.tlse.m1miage.ea.procrastinapp.server.repositories;

import fr.tlse.m1miage.ea.procrastinapp.server.models.ConfrontationPiegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfrontationPiegeRepository extends JpaRepository<ConfrontationPiegeEntity, Long> {
}
