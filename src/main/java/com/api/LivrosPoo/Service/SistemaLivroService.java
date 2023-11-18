package com.api.LivrosPoo.Service;


import com.api.LivrosPoo.Models.SistemaLivrosModel;
import com.api.LivrosPoo.Repositories.SistemaLivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SistemaLivroService {

    @Autowired //em algum momento ele deve injetar dependencias do repository
    SistemaLivrosRepository sistemaLivrosRepository;

    @Transactional
    public SistemaLivrosModel save(SistemaLivrosModel sistemaLivrosModel) {
        return sistemaLivrosRepository.save(sistemaLivrosModel);
    }

    public boolean existeNomeLivro(String nomeLivro) {

        return sistemaLivrosRepository.existeNomeLivro(nomeLivro);
    }

    public List<SistemaLivrosModel> findAll() {

        return sistemaLivrosRepository.findAll();
    }

    public Optional<SistemaLivrosModel> findById(Long id) {

        return sistemaLivrosRepository.findById(id);
    }

    @Transactional
    public void delete(SistemaLivrosModel sistemaLivrosModel) {

        sistemaLivrosRepository.delete(sistemaLivrosModel);
    }

}
