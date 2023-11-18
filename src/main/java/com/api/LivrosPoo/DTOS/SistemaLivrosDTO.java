package com.api.LivrosPoo.DTOS;

//classe para dados de entrada

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SistemaLivrosDTO {

    @NotBlank
    private String nomeLivro;

    @NotBlank
    private String autor;

}
