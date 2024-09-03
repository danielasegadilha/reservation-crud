package com.senac.daniela.gerenciamentosalas.repository;

import com.senac.daniela.gerenciamentosalas.entities.Registro;
import com.senac.daniela.gerenciamentosalas.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {

    @Query("SELECT r FROM Registro r WHERE r.status >= 0")
    List<Registro> getAllRegistros();

    @Query("SELECT r FROM Registro r WHERE r.status >= 0 AND r.id = :id")
    Optional<Registro> getRegistroAtivoById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE Registro r SET r.status = -1 WHERE r.id = :id")
    void markAsDeleteRegistro(@Param("id") int id);
}
