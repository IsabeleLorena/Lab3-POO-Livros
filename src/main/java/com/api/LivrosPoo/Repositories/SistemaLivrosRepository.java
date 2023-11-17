package com.api.LivrosPoo.Repositories;

import com.api.LivrosPoo.Models.SistemaLivrosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

//essa interface é um bean do spring

public interface SistemaLivrosRepository extends JpaRepository<SistemaLivrosModel, UUID> {
    @Query("SELECT CASE WHEN COUNT(l) > 0 THEN true ELSE false END FROM SistemaLivrosModel l WHERE l.nomeLivro = :nomeLivro")
    boolean existeNomeLivro(@Param("nomeLivro") String nomeLivro);

    Optional<SistemaLivrosModel> findById(Long id);
}