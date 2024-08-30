package com.senac.daniela.gerenciamentosalas.repository;

import com.senac.daniela.gerenciamentosalas.entities.Ambiente;
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
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.status >= 0")
    List<Usuario> getAllUsuarios();

    @Query("SELECT u FROM Usuario u WHERE u.status >= 0 AND u.id = :id")
    Optional<Usuario> getUsuarioAtivoById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET u.status = -1 WHERE u.id = :id")
    void markAsDeleteUsuario(@Param("id") int id);

}
