package com.senac.daniela.gerenciamentosalas.repository;

import com.senac.daniela.gerenciamentosalas.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
