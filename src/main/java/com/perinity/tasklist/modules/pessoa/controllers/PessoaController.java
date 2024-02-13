package com.perinity.tasklist.modules.pessoa.controllers;

import com.perinity.tasklist.modules.pessoa.dto.CreatePessoaDTO;
import com.perinity.tasklist.modules.pessoa.entities.PessoaEntity;
import com.perinity.tasklist.modules.pessoa.repositories.PessoaRepository;
import com.perinity.tasklist.modules.pessoa.useCases.CreatePessoaUseCase;
import com.perinity.tasklist.modules.pessoa.useCases.DeletePessoaUseCase;
import com.perinity.tasklist.modules.pessoa.useCases.UpdatePessoaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private CreatePessoaUseCase createPessoaUseCase;

    @Autowired
    private DeletePessoaUseCase deletePessoaUseCase;

    @Autowired
    private UpdatePessoaUseCase updatePessoaUseCase;

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/{id}")
    private Optional<PessoaEntity> getPessoaById(@PathVariable int id) {
        return this.pessoaRepository.findById(id);
    }

    @GetMapping
    private List<PessoaEntity> getAllPessoas() {
        return this.pessoaRepository.findAll();
    }

    @PostMapping
    private ResponseEntity<Object> createPessoa(@RequestBody CreatePessoaDTO dto) throws Exception {
        try {
            var result = this.createPessoaUseCase.execute(dto);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    private ResponseEntity<Object> updatePessoa(@PathVariable int id, @RequestBody CreatePessoaDTO dto) throws Exception {
        try {
            var result = this.updatePessoaUseCase.execute(id, dto);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deletePessoa(@PathVariable int id) throws Exception {
        try {
            var result = this.deletePessoaUseCase.execute(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
