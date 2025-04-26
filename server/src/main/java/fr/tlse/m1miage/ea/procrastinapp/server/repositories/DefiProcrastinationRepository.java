package fr.tlse.m1miage.ea.procrastinapp.server.repositories;

import fr.tlse.m1miage.ea.procrastinapp.server.models.DefiProcrastinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefiProcrastinationRepository extends JpaRepository<DefiProcrastinationEntity, Long> {
}
