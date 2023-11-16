package com.api.LivrosPoo.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

//classe que faz mapeamento para o jpa criar as tabelas no banco de dados

@Data
@Entity
@Table (name = "TB_SISTEMA_LIVROS")
public class SistemaLivrosModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //ID gerado por forma automatica geneationtyp auto
    private UUID id;

    @Column(nullable = false, unique = true, length = 10)
    private String nomeLivro;

    @Column(nullable = false, unique = true, length = 7)
    private String autor;

}
