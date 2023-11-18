package com.api.LivrosPoo.Controllers;


import com.api.LivrosPoo.DTOS.SistemaLivrosDTO;
import com.api.LivrosPoo.Models.SistemaLivrosModel;
import com.api.LivrosPoo.Service.SistemaLivroService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) //permite que acesse de qualquer fonte
@RequestMapping("/SistemaLivros")
public class SistemaLivrosController {

    @Autowired
    SistemaLivroService sistemaLivroService;

    @PostMapping("/inserir")
    public ResponseEntity<Object> saveLivros(@RequestBody @Valid SistemaLivrosDTO sistemaLivrosDTO) {
        try {
            if (sistemaLivroService.existeNomeLivro(sistemaLivrosDTO.getNomeLivro())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Livro já existe!");
            }

            var sistemaLivrosModel = new SistemaLivrosModel();
            BeanUtils.copyProperties(sistemaLivrosDTO, sistemaLivrosModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(sistemaLivroService.save(sistemaLivrosModel));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar o livro.");
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<SistemaLivrosModel>> getTodosLivros() {
        return ResponseEntity.status(HttpStatus.OK).body(sistemaLivroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUmLivro(@PathVariable(value = "id") Long id) {
        try {
            Optional<SistemaLivrosModel> sistemaLivrosModelOptional = sistemaLivroService.findById(id);
            if (!sistemaLivrosModelOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
            }
            return ResponseEntity.status(HttpStatus.OK).body(sistemaLivrosModelOptional.get());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar Id.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLivro(@PathVariable(value = "id") Long id) {
        try {
            Optional<SistemaLivrosModel> sistemaLivrosModelOptional = sistemaLivroService.findById(id);
            if (!sistemaLivrosModelOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado.");
            }
            sistemaLivroService.delete(sistemaLivrosModelOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Livro deletado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar o livro.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLivros(@PathVariable(value = "id") Long id, @RequestBody @Valid SistemaLivrosDTO sistemaLivrosDto) {
        try {
            Optional<SistemaLivrosModel> sistemaLivrosModelOptional = sistemaLivroService.findById(id);
            if (!sistemaLivrosModelOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado.");
            }

            SistemaLivrosModel existingLivro = sistemaLivrosModelOptional.get();
            BeanUtils.copyProperties(sistemaLivrosDto, existingLivro);

            return ResponseEntity.status(HttpStatus.OK).body(sistemaLivroService.save(existingLivro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar o livro.");
        }
    }
}