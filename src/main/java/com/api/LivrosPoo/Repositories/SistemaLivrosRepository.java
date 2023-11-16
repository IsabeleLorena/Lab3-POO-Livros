package com.api.LivrosPoo.Repositories;

import com.api.LivrosPoo.Models.SistemaLivrosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

//essa interface é um bean do spring


public interface SistemaLivrosRepository extends JpaRepository<SistemaLivrosModel, UUID> {

    //apenas declarar o metodos e não implementar ele usando o public ou private
    boolean existeNomeLivro(String nomeLivro);

    boolean existeNomeAutor(String autor);

}
