package com.perinity.tasklist.modules.pessoa.controllers;

import com.perinity.tasklist.modules.pessoa.dto.CreatePessoaDTO;
import com.perinity.tasklist.modules.pessoa.dto.PessoasWithHorasGastasDTO;
import com.perinity.tasklist.modules.pessoa.dto.PessoasWithMediaHorasDTO;
import com.perinity.tasklist.modules.pessoa.entities.PessoaEntity;
import com.perinity.tasklist.modules.pessoa.repositories.PessoaRepository;
import com.perinity.tasklist.modules.pessoa.useCases.CreatePessoaUseCase;
import com.perinity.tasklist.modules.pessoa.useCases.DeletePessoaUseCase;
import com.perinity.tasklist.modules.pessoa.useCases.FindPessoaWithMediaHorasUseCase;
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
    private FindPessoaWithMediaHorasUseCase findPessoaWithMediaHorasUseCase;

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/{id}")
    private Optional<PessoaEntity> getPessoaById(@PathVariable int id) {
        return this.pessoaRepository.findById(id);
    }

    @GetMapping("/all")
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




    @GetMapping
    private List<PessoasWithHorasGastasDTO> findPessoasWithHorasGastas() {
        return this.pessoaRepository.findPessoasWithHorasGastas();
    }

    @GetMapping("/gastos")
    private PessoasWithMediaHorasDTO findPessoaWithMediaHoras(
            @RequestParam(name = "nome", required = true) String nome,
            @RequestParam(name = "dataInicial", required = true) String dataInicial,
            @RequestParam(name = "dataFinal", required = true) String dataFinal) {
        return this.findPessoaWithMediaHorasUseCase.execute(nome, dataInicial, dataFinal);

    }
}
