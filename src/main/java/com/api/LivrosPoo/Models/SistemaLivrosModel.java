package com.api.LivrosPoo.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

//classe que faz mapeamento para o jpa criar as tabelas no banco de dados

@Data
@Entity
@Table(name = "TB_SISTEMA_LIVROS")
public class SistemaLivrosModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nomeLivro;

    @Column
    private String autor;

}
