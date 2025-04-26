package fr.tlse.m1miage.ea.procrastinapp.server.repositories;

import fr.tlse.m1miage.ea.procrastinapp.server.models.TacheAEviterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacheAEviterRepository extends JpaRepository<TacheAEviterEntity, Long> {
}
