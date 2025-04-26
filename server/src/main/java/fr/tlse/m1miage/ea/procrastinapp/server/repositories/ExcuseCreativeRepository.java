package fr.tlse.m1miage.ea.procrastinapp.server.repositories;

import fr.tlse.m1miage.ea.procrastinapp.server.models.ExcuseCreativeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcuseCreativeRepository extends JpaRepository<ExcuseCreativeEntity, Long> {
}
