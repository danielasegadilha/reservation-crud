package com.senac.daniela.gerenciamentosalas.repository;

import com.senac.daniela.gerenciamentosalas.entities.Ambiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AmbienteRepository extends JpaRepository<Ambiente, Integer> {

    @Query("SELECT a FROM Ambiente a WHERE a.status >= 0")
    List<Ambiente> getAllAmbientes();

    @Query("SELECT a FROM Ambiente a WHERE a.status >= 0 AND a.id = :id")
    Optional<Ambiente> getAmbienteAtivoById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE Ambiente a SET a.status = -1 WHERE a.id = :id")
    void markAsDeleteAmbiente(@Param("id") int id);

}
