package com.senac.daniela.gerenciamentosalas.repository;

import com.senac.daniela.gerenciamentosalas.entities.PlanejamentoAlocacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanejamentoAlocacaoRepository extends JpaRepository<PlanejamentoAlocacao, Integer> {
}
