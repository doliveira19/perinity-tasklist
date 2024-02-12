package com.perinity.tasklist.modules.pessoa.controllers;

import com.perinity.tasklist.modules.pessoa.dto.CreatePessoaDTO;
import com.perinity.tasklist.modules.pessoa.entities.PessoaEntity;
import com.perinity.tasklist.modules.pessoa.useCases.CreatePessoaUseCase;
import com.perinity.tasklist.modules.pessoa.useCases.DeletePessoaUseCase;
import com.perinity.tasklist.modules.pessoa.useCases.UpdatePessoaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private CreatePessoaUseCase createPessoaUseCase;

    @Autowired
    private DeletePessoaUseCase deletePessoaUseCase;

    @Autowired
    private UpdatePessoaUseCase updatePessoaUseCase;

    @PostMapping
    private PessoaEntity createPessoa(@RequestBody CreatePessoaDTO dto) throws Exception {
        return this.createPessoaUseCase.execute(dto);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Object> updatePessoa(@PathVariable int id, @RequestBody CreatePessoaDTO dto) throws Exception {
        try {
            var result =  this.updatePessoaUseCase.execute(id, dto);
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
