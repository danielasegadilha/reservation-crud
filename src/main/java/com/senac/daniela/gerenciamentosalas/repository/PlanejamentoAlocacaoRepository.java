package com.senac.daniela.gerenciamentosalas.repository;

import com.senac.daniela.gerenciamentosalas.entities.PlanejamentoAlocacao;
import com.senac.daniela.gerenciamentosalas.entities.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanejamentoAlocacaoRepository extends JpaRepository<PlanejamentoAlocacao, Integer> {

    @Query("SELECT p FROM PlanejamentoAlocacao p WHERE p.status >= 0")
    List<PlanejamentoAlocacao> getAllPlanejamentoAlocacoes();

    @Query("SELECT p FROM PlanejamentoAlocacao p WHERE p.status >= 0 AND p.id = :id")
    Optional<PlanejamentoAlocacao> getPlanejamentoAlocacaoAtivoById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE PlanejamentoAlocacao p SET p.status = -1 WHERE p.id = :id")
    void markAsDeletePlanejamentoAlocacao(@Param("id") int id);
}
