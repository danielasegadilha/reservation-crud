package com.senac.daniela.gerenciamentosalas.repository;

import com.senac.daniela.gerenciamentosalas.entities.DiasSemAlocacao;
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
public interface DiasSemAlocacaoRepository extends JpaRepository<DiasSemAlocacao, Integer> {

    @Query("SELECT d FROM DiasSemAlocacao d WHERE d.status >= 0")
    List<DiasSemAlocacao> getAllDiasSemAlocacao();

    @Query("SELECT d FROM DiasSemAlocacao d WHERE d.status >= 0 AND d.id = :id")
    Optional<DiasSemAlocacao> getDiasSemAlocacaoAtivaById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE DiasSemAlocacao d SET d.status = -1 WHERE d.id = :id")
    void markAsDeleteDiasSemAlocacao(@Param("id") int id);
}
