package com.api.LivrosPoo.Repositories;

import com.api.LivrosPoo.Models.SistemaLivrosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//essa interface é um bean do spring

@Repository
public interface SistemaLivrosRepository extends JpaRepository<SistemaLivrosModel, UUID> {

    //apenas declarar o metodos e não implementar ele usando o public ou private
    @Autowired
    boolean existeNomeLivro(String nomeLivro);
}
