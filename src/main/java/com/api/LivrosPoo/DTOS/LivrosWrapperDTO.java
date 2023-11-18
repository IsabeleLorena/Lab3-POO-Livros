package com.api.LivrosPoo.DTOS;

import com.api.LivrosPoo.Models.SistemaLivrosModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LivrosWrapperDTO {
    @JsonProperty("Livros e Autores")
    private List<SistemaLivrosModel> livros;
    public LivrosWrapperDTO(List<SistemaLivrosModel> livros) {
        this.livros = livros;
    }
    @JsonProperty("Livros e Autores")
    public List<SistemaLivrosModel> getLivros() {
        return livros;
    }

    public void setLivros(List<SistemaLivrosModel> livros) {
        this.livros = livros;
    }
}
