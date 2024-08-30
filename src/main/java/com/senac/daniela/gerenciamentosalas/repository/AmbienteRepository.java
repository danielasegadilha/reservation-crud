package com.senac.daniela.gerenciamentosalas.repository;

import com.senac.daniela.gerenciamentosalas.entities.Ambiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AmbienteRepository extends JpaRepository<Ambiente, Integer> {

    @Query("SELECT a FROM Ambiente a WHERE a.status >= 0 AND a.id = :id")
    Optional<Ambiente> getAmbienteAtivoById(@Param("id") int id);

}
