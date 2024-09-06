package com.senac.daniela.gerenciamentosalas.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.senac.daniela.gerenciamentosalas.entities.Reserva;
import com.senac.daniela.gerenciamentosalas.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query("SELECT r FROM Reserva r WHERE r.status >= 0")
    List<Reserva> getAllReservas();

    @Query("SELECT r FROM Reserva r WHERE r.status >= 0 AND r.id = :id")
    Optional<Reserva> getReservaAtivaById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE Reserva r SET r.status = -1 WHERE r.id = :id")
    void markAsDeleteReserva(@Param("id") int id);
}
