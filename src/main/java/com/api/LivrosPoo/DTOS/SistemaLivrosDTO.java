package com.api.LivrosPoo.DTOS;

//classe para dados de entrada

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SistemaLivrosDTO {

    @NotBlank
    @Size(max = 7)
    private String nomeLivro;

    @NotBlank
    private String autor;

}
