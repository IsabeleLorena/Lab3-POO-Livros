package com.api.LivrosPoo.Controllers;


import com.api.LivrosPoo.DTOS.SistemaLivrosDTO;
import com.api.LivrosPoo.Models.SistemaLivrosModel;
import com.api.LivrosPoo.Service.SistemaLivroService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin (origins = "*", maxAge = 3600) //permitir que acesse de qualquer fonte
@RequestMapping ("/SistemaLivros")
public class SistemaLivrosController {

    @Autowired
    SistemaLivroService sistemaLivroService;

    @PostMapping("/inserir")
    public ResponseEntity<Object> saveLivros(@RequestBody @Valid SistemaLivrosDTO sistemaLivrosDTO){ //recebo o dto(dados de entrada) com os campos que o cliente enviou
        if(sistemaLivroService.existeNomeLivro(sistemaLivrosDTO.getNomeLivro())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Livro já adicionado");
        }
        var  sistemaLivrosModel = new SistemaLivrosModel(); //injetou a dependencia para salvar na entidade precisa ser em model, então converte de DTO para Model
        //var já identifica a classe
        BeanUtils.copyProperties(sistemaLivrosDTO,sistemaLivrosModel); //converto o DTO em Model usando o BeanUtils copy properties
        return ResponseEntity.status(HttpStatus.CREATED).body(sistemaLivroService.save(sistemaLivrosModel));//resposta dos dados
    }

    @GetMapping("/todos")
    public ResponseEntity<List<SistemaLivrosModel>> getTodosLivros (@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return (ResponseEntity<List<SistemaLivrosModel>>) ResponseEntity.status(HttpStatus.OK).body(sistemaLivroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUmLivro (@PathVariable(value = "id") UUID id){//usar o object pq mesmo se não haja nenhum registro retorna que o registro n existe
        Optional<SistemaLivrosModel> sistemaLivrosModelOptional = sistemaLivroService.findById(id); //
        if (!sistemaLivrosModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(sistemaLivrosModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLivro(@PathVariable(value = "id") UUID id){
        Optional<SistemaLivrosModel> sistemaLivrosModelOptional = sistemaLivroService.findById(id);
        if (!sistemaLivrosModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado.");
        }
        sistemaLivroService.delete(sistemaLivrosModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Livro deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLivros(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid SistemaLivrosDTO sistemaLivrosDto){
        Optional<SistemaLivrosModel> sistemaLivrosModelOptional = sistemaLivroService.findById(id);
        if (!sistemaLivrosModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(sistemaLivroService.save(new SistemaLivrosModel()));
    }

}
