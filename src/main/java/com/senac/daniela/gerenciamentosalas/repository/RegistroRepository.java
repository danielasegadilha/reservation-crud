package com.senac.daniela.gerenciamentosalas.repository;

import com.senac.daniela.gerenciamentosalas.entities.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {
}
