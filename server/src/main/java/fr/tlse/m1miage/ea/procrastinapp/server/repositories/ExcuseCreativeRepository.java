package fr.tlse.m1miage.ea.procrastinapp.server.repositories;

import fr.tlse.m1miage.ea.procrastinapp.server.models.ExcuseCreativeEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcuseCreativeRepository extends JpaRepository<ExcuseCreativeEntity, Long> {

    //indique à Spring que c'est une modification
    @Modifying
    //obligatoire car modification de donnée
    @Transactional
    //requete en JPQL
    @Query("update ExcuseCreativeEntity e set e.votesRecus = e.votesRecus + 1 where e.id = :id")
    int incrementVoteById(@Param("id") Long id);
}
